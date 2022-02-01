import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class axla
  implements View.OnClickListener
{
  private bkzi a;
  
  public axla(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject5 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.finish();
      continue;
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682A", "0X800682A", 0, 0, "", "", "", "");
      Object localObject4 = paramView.getTag();
      Object localObject1 = paramView.getContext();
      if ((!(localObject4 instanceof axlj)) || (localObject1 == null)) {
        continue;
      }
      localObject4 = (axlj)localObject4;
      localObject5 = new ArrayList();
      int i = 0;
      while (i <= 3)
      {
        ((List)localObject5).add(bkzw.a(i));
        i += 1;
      }
      Object localObject6 = new bkzw((Context)localObject1);
      ((bkzw)localObject6).a((List)localObject5);
      this.jdField_a_of_type_Bkzi = bkzw.a((Context)localObject1, (bkzw)localObject6, new axlb(this, (axlj)localObject4), null, null, true);
      this.jdField_a_of_type_Bkzi.show();
      continue;
      if (localObject5 == null) {
        continue;
      }
      localObject1 = Settings.Secure.getString(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.getContentResolver(), "android_id");
      try
      {
        localObject4 = ((axkb)localObject5).a();
        if (localObject4 == null) {
          continue;
        }
        localObject4 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (SongInfo)localObject4);
        if (!MusicPlayerActivity.a().containsKey(localObject4)) {
          continue;
        }
        localObject5 = paramView.getTag();
        if (!paramView.isSelected()) {
          break label420;
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X8006829", "0X8006829", 0, 0, "", "", "", "");
        MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject4)).longValue(), false);
        paramView.setSelected(false);
        MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).setImageResource(2130841350);
        if (!(localObject5 instanceof Integer)) {
          continue;
        }
        i = ((Integer)localObject5).intValue();
        MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, 2130841350, i);
      }
      catch (RemoteException localRemoteException1)
      {
        QLog.e("MusicPlayerActivity", 1, "add favourite RemoteException ", localRemoteException1);
      }
      continue;
      label420:
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X8006828", "0X8006828", 0, 0, "", "", "", "");
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).a(localRemoteException1, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject4)).longValue(), true);
      paramView.setSelected(true);
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).setImageResource(2130841349);
      if (!(localObject5 instanceof Integer)) {
        continue;
      }
      i = ((Integer)localObject5).intValue();
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, 2130841349, i);
      continue;
      if (localObject5 == null) {
        continue;
      }
      try
      {
        switch (((axkb)localObject5).a())
        {
        case 2: 
          localObject4 = ((axkb)localObject5).a();
          if ((localObject4 == null) || (localObject4.length <= 0)) {
            continue;
          }
          i = ((axkb)localObject5).g();
          if (i >= 0) {
            if (i < localObject4.length) {}
          }
          break;
        case 3: 
        default: 
          for (;;)
          {
            for (;;)
            {
              label568:
              localObject6 = ((axkb)localObject5).a();
              if (TextUtils.isEmpty((CharSequence)localObject6)) {
                break;
              }
              ((axkb)localObject5).a((String)localObject6, (SongInfo[])localObject4, i);
              if (localRemoteException1 == null) {
                break;
              }
              localObject4 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, localRemoteException1);
              if (!MusicPlayerActivity.b().containsKey(localObject4)) {
                break;
              }
              localObject4 = (axlk)MusicPlayerActivity.b().get(localObject4);
              Object localObject2 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (axkb)localObject5, localRemoteException1, ((axlk)localObject4).a);
              MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (axlk)localObject4, (String)localObject2);
              break;
              ((axkb)localObject5).a();
              break;
              ((axkb)localObject5).b();
              break;
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682B", "0X800682B", 0, 0, "", "", "", "");
              if (axlm.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, "com.tencent.qqmusic"))
              {
                localObject4 = null;
                localObject2 = localObject4;
                if (localObject5 != null) {}
                try
                {
                  localObject2 = ((axkb)localObject5).a();
                  if (localObject2 == null) {
                    break;
                  }
                  localObject2 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (SongInfo)localObject2);
                  if (!MusicPlayerActivity.a().containsKey(localObject2)) {
                    break;
                  }
                  localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("androidqqmusic://form=webpage&mid=23&k1=0&k2=%s&download=1&action=download", new Object[] { String.valueOf(MusicPlayerActivity.a().get(localObject2)) })));
                  ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_qqmusic");
                  this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.startActivity((Intent)localObject2);
                  bdla.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682C", "0X800682C", 0, 0, "", "", "", "");
                }
                catch (RemoteException localRemoteException2)
                {
                  for (;;)
                  {
                    QLog.e("MusicPlayerActivity", 1, "music player activity RemoteException ", localRemoteException2);
                    localObject3 = localObject4;
                  }
                }
              }
            }
            Object localObject3 = (bkzi)bkzz.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, null);
            ((bkzi)localObject3).a(2131694196);
            ((bkzi)localObject3).a(2131694198, 2);
            ((bkzi)localObject3).c(2131694195);
            ((bkzi)localObject3).a(new axlc(this, paramView, (bkzi)localObject3));
            ((bkzi)localObject3).show();
            break;
            localObject3 = null;
            continue;
            break label568;
            localObject3 = localObject4[0];
            i = 0;
          }
        }
      }
      catch (RemoteException localRemoteException3) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axla
 * JD-Core Version:    0.7.0.1
 */