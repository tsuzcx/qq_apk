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

public class awyy
  implements View.OnClickListener
{
  private bkho a;
  
  public awyy(MusicPlayerActivity paramMusicPlayerActivity) {}
  
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682A", "0X800682A", 0, 0, "", "", "", "");
      Object localObject4 = paramView.getTag();
      Object localObject1 = paramView.getContext();
      if ((!(localObject4 instanceof awzh)) || (localObject1 == null)) {
        continue;
      }
      localObject4 = (awzh)localObject4;
      localObject5 = new ArrayList();
      int i = 0;
      while (i <= 3)
      {
        ((List)localObject5).add(bkic.a(i));
        i += 1;
      }
      Object localObject6 = new bkic((Context)localObject1);
      ((bkic)localObject6).a((List)localObject5);
      this.jdField_a_of_type_Bkho = bkic.a((Context)localObject1, (bkic)localObject6, new awyz(this, (awzh)localObject4), null, null, true);
      this.jdField_a_of_type_Bkho.show();
      continue;
      if (localObject5 == null) {
        continue;
      }
      localObject1 = Settings.Secure.getString(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.getContentResolver(), "android_id");
      try
      {
        localObject4 = ((awxz)localObject5).a();
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
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X8006829", "0X8006829", 0, 0, "", "", "", "");
        MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject4)).longValue(), false);
        paramView.setSelected(false);
        MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).setImageResource(2130841298);
        if (!(localObject5 instanceof Integer)) {
          continue;
        }
        i = ((Integer)localObject5).intValue();
        MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, 2130841298, i);
      }
      catch (RemoteException localRemoteException1)
      {
        QLog.e("MusicPlayerActivity", 1, "add favourite RemoteException ", localRemoteException1);
      }
      continue;
      label420:
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X8006828", "0X8006828", 0, 0, "", "", "", "");
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).a(localRemoteException1, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject4)).longValue(), true);
      paramView.setSelected(true);
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).setImageResource(2130841297);
      if (!(localObject5 instanceof Integer)) {
        continue;
      }
      i = ((Integer)localObject5).intValue();
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, 2130841297, i);
      continue;
      if (localObject5 == null) {
        continue;
      }
      try
      {
        switch (((awxz)localObject5).a())
        {
        case 2: 
          localObject4 = ((awxz)localObject5).a();
          if ((localObject4 == null) || (localObject4.length <= 0)) {
            continue;
          }
          i = ((awxz)localObject5).g();
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
              localObject6 = ((awxz)localObject5).a();
              if (TextUtils.isEmpty((CharSequence)localObject6)) {
                break;
              }
              ((awxz)localObject5).a((String)localObject6, (SongInfo[])localObject4, i);
              if (localRemoteException1 == null) {
                break;
              }
              localObject4 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, localRemoteException1);
              if (!MusicPlayerActivity.b().containsKey(localObject4)) {
                break;
              }
              localObject4 = (awzi)MusicPlayerActivity.b().get(localObject4);
              Object localObject2 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (awxz)localObject5, localRemoteException1, ((awzi)localObject4).a);
              MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (awzi)localObject4, (String)localObject2);
              break;
              ((awxz)localObject5).a();
              break;
              ((awxz)localObject5).b();
              break;
              bcst.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682B", "0X800682B", 0, 0, "", "", "", "");
              if (awzk.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, "com.tencent.qqmusic"))
              {
                localObject4 = null;
                localObject2 = localObject4;
                if (localObject5 != null) {}
                try
                {
                  localObject2 = ((awxz)localObject5).a();
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
                  bcst.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682C", "0X800682C", 0, 0, "", "", "", "");
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
            Object localObject3 = (bkho)bkif.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, null);
            ((bkho)localObject3).a(2131693889);
            ((bkho)localObject3).a(2131693891, 2);
            ((bkho)localObject3).c(2131693888);
            ((bkho)localObject3).a(new awza(this, paramView, (bkho)localObject3));
            ((bkho)localObject3).show();
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
 * Qualified Name:     awyy
 * JD-Core Version:    0.7.0.1
 */