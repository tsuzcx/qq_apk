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

class ayrw
  implements View.OnClickListener
{
  ayrw(ayro paramayro, ayxd paramayxd, int paramInt, Context paramContext, boolean paramBoolean, SongInfo paramSongInfo, ayot paramayot) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    paramView = this.jdField_a_of_type_Ayxd.a;
    paramView.setTag(Integer.valueOf(this.jdField_a_of_type_Int));
    ayro.a(this.jdField_a_of_type_Ayro, new WeakReference(paramView));
    if ((QQPlayerService.a() == 2) && (ayro.a(this.jdField_a_of_type_Ayro) == ayvm.a))
    {
      QQPlayerService.c(this.jdField_a_of_type_AndroidContentContext);
      ayvm.a = -1L;
      paramView.clearAnimation();
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setImageResource(2130849086);
        i = 0;
      }
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      JSONObject localJSONObject;
      if (ayif.b.containsKey(this.jdField_a_of_type_Ayot))
      {
        paramView = (ayig)ayif.b.get(this.jdField_a_of_type_Ayot);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("project", aysc.a());
        localJSONObject.put("event_src", "client");
        localJSONObject.put("obj_lct", paramView.jdField_a_of_type_Int);
        localJSONObject.put("get_src", "web");
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528();
        if ((this.jdField_a_of_type_AndroidContentContext instanceof UniteSearchActivity))
        {
          paramView = "all_result";
          localReportModelDC02528 = localReportModelDC02528.module(paramView);
          if (i == 0) {
            break label491;
          }
          paramView = "play_music";
          aysc.a(null, localReportModelDC02528.action(paramView).obj1(this.jdField_a_of_type_Ayot.a + "").obj2(this.jdField_a_of_type_Ayot.d).ver1(UniteSearchActivity.b).ver2(aysc.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + ayif.a));
          do
          {
            return;
            paramView.setImageResource(2130849085);
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
          paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.b);
          paramView.putExtra("param_force_internal_browser", true);
          QQPlayerService.a(paramView);
          if (QQPlayerService.a() == null) {
            QQPlayerService.a(new Bundle());
          }
          QQPlayerService.a(this.jdField_a_of_type_Ayro);
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
          label491:
          paramView = "pause_music";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrw
 * JD-Core Version:    0.7.0.1
 */