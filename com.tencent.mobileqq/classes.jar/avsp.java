import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class avsp
  implements View.OnClickListener
{
  avsp(avsh paramavsh, avxw paramavxw, int paramInt, Context paramContext, boolean paramBoolean, SongInfo paramSongInfo, avpm paramavpm) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    paramView = this.jdField_a_of_type_Avxw.a;
    paramView.setTag(Integer.valueOf(this.jdField_a_of_type_Int));
    avsh.a(this.jdField_a_of_type_Avsh, new WeakReference(paramView));
    if ((QQPlayerService.a() == 2) && (avsh.a(this.jdField_a_of_type_Avsh) == avwf.a))
    {
      QQPlayerService.c(this.jdField_a_of_type_AndroidContentContext);
      avwf.a = -1L;
      paramView.clearAnimation();
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setImageResource(2130848345);
        i = 0;
      }
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      JSONObject localJSONObject;
      if (avjb.b.containsKey(this.jdField_a_of_type_Avpm))
      {
        paramView = (avjc)avjb.b.get(this.jdField_a_of_type_Avpm);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("project", avsv.a());
        localJSONObject.put("event_src", "client");
        localJSONObject.put("obj_lct", paramView.jdField_a_of_type_Int);
        localJSONObject.put("get_src", "web");
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528();
        if ((this.jdField_a_of_type_AndroidContentContext instanceof UniteSearchActivity))
        {
          paramView = "all_result";
          localReportModelDC02528 = localReportModelDC02528.module(paramView);
          if (i == 0) {
            break label492;
          }
          paramView = "play_music";
          avsv.a(null, localReportModelDC02528.action(paramView).obj1(this.jdField_a_of_type_Avpm.a + "").obj2(this.jdField_a_of_type_Avpm.d).ver1(UniteSearchActivity.b).ver2(avsv.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + avjb.a));
          do
          {
            return;
            paramView.setImageResource(2130848344);
            i = 0;
            break;
            paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if ((paramView == null) || (!paramView.c())) {
              break label361;
            }
          } while (!QLog.isColorLevel());
          QLog.i("QQPlayerService", 2, "Video Chatting is going on, don't play music.");
          return;
          label361:
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, MusicPlayerActivity.class);
          paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.a);
          paramView.putExtra("param_force_internal_browser", true);
          QQPlayerService.a(paramView);
          if (QQPlayerService.a() == null) {
            QQPlayerService.a(new Bundle());
          }
          QQPlayerService.a(this.jdField_a_of_type_Avsh);
          QQPlayerService.a(101);
          QQPlayerService.a(this.jdField_a_of_type_AndroidContentContext, QQPlayerService.a(), new SongInfo[] { this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo });
        }
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "e = " + paramView);
          continue;
          paramView = "subweb_search";
          continue;
          label492:
          paramView = "pause_music";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsp
 * JD-Core Version:    0.7.0.1
 */