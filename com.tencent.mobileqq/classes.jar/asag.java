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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class asag
  implements View.OnClickListener
{
  private begr a;
  
  public asag(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.finish();
      return;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682A", "0X800682A", 0, 0, "", "", "", "");
      Object localObject1 = paramView.getTag();
      paramView = paramView.getContext();
      if ((!(localObject1 instanceof asap)) || (paramView == null)) {
        continue;
      }
      localObject1 = (asap)localObject1;
      localObject2 = new ArrayList();
      int i = 0;
      while (i <= 3)
      {
        ((List)localObject2).add(behb.a(i));
        i += 1;
      }
      Object localObject3 = new behb(paramView);
      ((behb)localObject3).a((List)localObject2);
      this.jdField_a_of_type_Begr = behb.a(paramView, (behb)localObject3, new asah(this, (asap)localObject1), null, null, true);
      this.jdField_a_of_type_Begr.show();
      return;
      if (localObject2 == null) {
        continue;
      }
      localObject1 = Settings.Secure.getString(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.getContentResolver(), "android_id");
      try
      {
        localObject2 = ((arzh)localObject2).a();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (SongInfo)localObject2);
        if (!MusicPlayerActivity.a().containsKey(localObject2)) {
          continue;
        }
        localObject3 = paramView.getTag();
        if (paramView.isSelected())
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X8006829", "0X8006829", 0, 0, "", "", "", "");
          MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject2)).longValue(), false);
          paramView.setSelected(false);
          MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).setImageResource(2130840865);
          if (!(localObject3 instanceof Integer)) {
            continue;
          }
          i = ((Integer)localObject3).intValue();
          MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, 2130840865, i);
          return;
        }
      }
      catch (RemoteException paramView)
      {
        QLog.e("MusicPlayerActivity", 1, "add favourite RemoteException ", paramView);
        return;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X8006828", "0X8006828", 0, 0, "", "", "", "");
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject2)).longValue(), true);
      paramView.setSelected(true);
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).setImageResource(2130840864);
      if (!(localObject3 instanceof Integer)) {
        continue;
      }
      i = ((Integer)localObject3).intValue();
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, 2130840864, i);
      return;
      if (localObject2 == null) {
        continue;
      }
      try
      {
        switch (((arzh)localObject2).a())
        {
        case 2: 
          localObject1 = ((arzh)localObject2).a();
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            continue;
          }
          i = ((arzh)localObject2).g();
          if (i >= 0) {
            if (i < localObject1.length) {}
          }
          break;
        case 3: 
        default: 
          for (;;)
          {
            for (;;)
            {
              label544:
              localObject3 = ((arzh)localObject2).a();
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break;
              }
              ((arzh)localObject2).a((String)localObject3, (SongInfo[])localObject1, i);
              if (paramView == null) {
                break;
              }
              localObject1 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, paramView);
              if (!MusicPlayerActivity.b().containsKey(localObject1)) {
                break;
              }
              localObject1 = (asaq)MusicPlayerActivity.b().get(localObject1);
              paramView = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (arzh)localObject2, paramView, ((asaq)localObject1).a);
              MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (asaq)localObject1, paramView);
              return;
              ((arzh)localObject2).a();
              return;
              ((arzh)localObject2).b();
              return;
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682B", "0X800682B", 0, 0, "", "", "", "");
              if (asas.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, "com.tencent.qqmusic"))
              {
                localObject1 = null;
                paramView = (View)localObject1;
                if (localObject2 != null) {}
                try
                {
                  paramView = ((arzh)localObject2).a();
                  if (paramView == null) {
                    break;
                  }
                  paramView = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, paramView);
                  if (!MusicPlayerActivity.a().containsKey(paramView)) {
                    break;
                  }
                  paramView = new Intent("android.intent.action.VIEW", Uri.parse(String.format("androidqqmusic://form=webpage&mid=23&k1=0&k2=%s&download=1&action=download", new Object[] { String.valueOf(MusicPlayerActivity.a().get(paramView)) })));
                  paramView.putExtra("big_brother_source_key", "biz_src_qqmusic");
                  this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.startActivity(paramView);
                  awqx.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682C", "0X800682C", 0, 0, "", "", "", "");
                  return;
                }
                catch (RemoteException paramView)
                {
                  for (;;)
                  {
                    QLog.e("MusicPlayerActivity", 1, "music player activity RemoteException ", paramView);
                    paramView = (View)localObject1;
                  }
                }
              }
            }
            localObject1 = (begr)behe.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, null);
            ((begr)localObject1).a(2131628816);
            ((begr)localObject1).a(2131628818, 2);
            ((begr)localObject1).c(2131628815);
            ((begr)localObject1).a(new asai(this, paramView, (begr)localObject1));
            ((begr)localObject1).show();
            return;
            paramView = null;
            continue;
            break label544;
            paramView = localObject1[0];
            i = 0;
          }
          return;
        }
      }
      catch (RemoteException paramView) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asag
 * JD-Core Version:    0.7.0.1
 */