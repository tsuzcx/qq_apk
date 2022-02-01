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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class bcjs
  implements View.OnClickListener
{
  bcjs(bcjk parambcjk, bcoz parambcoz, int paramInt, Context paramContext, boolean paramBoolean, SongInfo paramSongInfo, bcgq parambcgq) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    Object localObject = this.jdField_a_of_type_Bcoz.a;
    ((ImageView)localObject).setTag(Integer.valueOf(this.jdField_a_of_type_Int));
    bcjk.a(this.jdField_a_of_type_Bcjk, new WeakReference(localObject));
    if ((QQPlayerService.a() == 2) && (bcjk.a(this.jdField_a_of_type_Bcjk) == bcni.a))
    {
      QQPlayerService.c(this.jdField_a_of_type_AndroidContentContext);
      bcni.a = -1L;
      ((ImageView)localObject).clearAnimation();
      if (this.jdField_a_of_type_Boolean)
      {
        ((ImageView)localObject).setImageResource(2130849636);
        i = 0;
      }
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      JSONObject localJSONObject;
      if (bbzx.b.containsKey(this.jdField_a_of_type_Bcgq))
      {
        localObject = (bbzy)bbzx.b.get(this.jdField_a_of_type_Bcgq);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("project", bcjy.a());
        localJSONObject.put("event_src", "client");
        localJSONObject.put("obj_lct", ((bbzy)localObject).jdField_a_of_type_Int);
        localJSONObject.put("get_src", "web");
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528();
        if ((this.jdField_a_of_type_AndroidContentContext instanceof UniteSearchActivity))
        {
          localObject = "all_result";
          localReportModelDC02528 = localReportModelDC02528.module((String)localObject);
          if (i == 0) {
            break label503;
          }
          localObject = "play_music";
          bcjy.a(null, localReportModelDC02528.action((String)localObject).obj1(this.jdField_a_of_type_Bcgq.a + "").obj2(this.jdField_a_of_type_Bcgq.d).ver1(UniteSearchActivity.b).ver2(bcjy.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzx.a));
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            ((ImageView)localObject).setImageResource(2130849635);
            i = 0;
            break;
            localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if ((localObject == null) || (!((QQAppInterface)localObject).d())) {
              break label372;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QQPlayerService", 2, "Video Chatting is going on, don't play music.");
            }
          }
          label372:
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, MusicPlayerActivity.class);
          ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.b);
          ((Intent)localObject).putExtra("param_force_internal_browser", true);
          QQPlayerService.a((Intent)localObject);
          if (QQPlayerService.a() == null) {
            QQPlayerService.a(new Bundle());
          }
          QQPlayerService.a(this.jdField_a_of_type_Bcjk);
          QQPlayerService.a(101);
          QQPlayerService.a(this.jdField_a_of_type_AndroidContentContext, QQPlayerService.a(), new SongInfo[] { this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "e = " + localJSONException);
          continue;
          String str = "subweb_search";
          continue;
          label503:
          str = "pause_music";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjs
 * JD-Core Version:    0.7.0.1
 */