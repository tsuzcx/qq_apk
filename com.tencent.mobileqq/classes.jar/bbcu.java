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

class bbcu
  implements View.OnClickListener
{
  bbcu(bbcm parambbcm, bbib parambbib, int paramInt, Context paramContext, boolean paramBoolean, SongInfo paramSongInfo, bazs parambazs) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    Object localObject = this.jdField_a_of_type_Bbib.a;
    ((ImageView)localObject).setTag(Integer.valueOf(this.jdField_a_of_type_Int));
    bbcm.a(this.jdField_a_of_type_Bbcm, new WeakReference(localObject));
    if ((QQPlayerService.a() == 2) && (bbcm.a(this.jdField_a_of_type_Bbcm) == bbgk.a))
    {
      QQPlayerService.c(this.jdField_a_of_type_AndroidContentContext);
      bbgk.a = -1L;
      ((ImageView)localObject).clearAnimation();
      if (this.jdField_a_of_type_Boolean)
      {
        ((ImageView)localObject).setImageResource(2130849548);
        i = 0;
      }
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      JSONObject localJSONObject;
      if (batb.b.containsKey(this.jdField_a_of_type_Bazs))
      {
        localObject = (batc)batb.b.get(this.jdField_a_of_type_Bazs);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("project", bbda.a());
        localJSONObject.put("event_src", "client");
        localJSONObject.put("obj_lct", ((batc)localObject).jdField_a_of_type_Int);
        localJSONObject.put("get_src", "web");
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528();
        if ((this.jdField_a_of_type_AndroidContentContext instanceof UniteSearchActivity))
        {
          localObject = "all_result";
          localReportModelDC02528 = localReportModelDC02528.module((String)localObject);
          if (i == 0) {
            break label504;
          }
          localObject = "play_music";
          bbda.a(null, localReportModelDC02528.action((String)localObject).obj1(this.jdField_a_of_type_Bazs.a + "").obj2(this.jdField_a_of_type_Bazs.d).ver1(UniteSearchActivity.b).ver2(bbda.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + batb.a));
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            ((ImageView)localObject).setImageResource(2130849547);
            i = 0;
            break;
            localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if ((localObject == null) || (!((QQAppInterface)localObject).isVideoChatting())) {
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
          QQPlayerService.a(this.jdField_a_of_type_Bbcm);
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
          label504:
          str = "pause_music";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcu
 * JD-Core Version:    0.7.0.1
 */