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

public class aunj
  implements View.OnClickListener
{
  private bhpy a;
  
  public aunj(MusicPlayerActivity paramMusicPlayerActivity) {}
  
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682A", "0X800682A", 0, 0, "", "", "", "");
      Object localObject1 = paramView.getTag();
      paramView = paramView.getContext();
      if ((!(localObject1 instanceof auns)) || (paramView == null)) {
        continue;
      }
      localObject1 = (auns)localObject1;
      localObject2 = new ArrayList();
      int i = 0;
      while (i <= 3)
      {
        ((List)localObject2).add(bhqi.a(i));
        i += 1;
      }
      Object localObject3 = new bhqi(paramView);
      ((bhqi)localObject3).a((List)localObject2);
      this.jdField_a_of_type_Bhpy = bhqi.a(paramView, (bhqi)localObject3, new aunk(this, (auns)localObject1), null, null, true);
      this.jdField_a_of_type_Bhpy.show();
      return;
      if (localObject2 == null) {
        continue;
      }
      localObject1 = Settings.Secure.getString(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.getContentResolver(), "android_id");
      try
      {
        localObject2 = ((aumk)localObject2).a();
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
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X8006829", "0X8006829", 0, 0, "", "", "", "");
          MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject2)).longValue(), false);
          paramView.setSelected(false);
          MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).setImageResource(2130841047);
          if (!(localObject3 instanceof Integer)) {
            continue;
          }
          i = ((Integer)localObject3).intValue();
          MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, 2130841047, i);
          return;
        }
      }
      catch (RemoteException paramView)
      {
        QLog.e("MusicPlayerActivity", 1, "add favourite RemoteException ", paramView);
        return;
      }
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X8006828", "0X8006828", 0, 0, "", "", "", "");
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app.getLongAccountUin(), ((Long)MusicPlayerActivity.a().get(localObject2)).longValue(), true);
      paramView.setSelected(true);
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity).setImageResource(2130841046);
      if (!(localObject3 instanceof Integer)) {
        continue;
      }
      i = ((Integer)localObject3).intValue();
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, 2130841046, i);
      return;
      if (localObject2 == null) {
        continue;
      }
      try
      {
        switch (((aumk)localObject2).a())
        {
        case 2: 
          localObject1 = ((aumk)localObject2).a();
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            continue;
          }
          i = ((aumk)localObject2).g();
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
              localObject3 = ((aumk)localObject2).a();
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break;
              }
              ((aumk)localObject2).a((String)localObject3, (SongInfo[])localObject1, i);
              if (paramView == null) {
                break;
              }
              localObject1 = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, paramView);
              if (!MusicPlayerActivity.b().containsKey(localObject1)) {
                break;
              }
              localObject1 = (aunt)MusicPlayerActivity.b().get(localObject1);
              paramView = MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (aumk)localObject2, paramView, ((aunt)localObject1).a);
              MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, (aunt)localObject1, paramView);
              return;
              ((aumk)localObject2).a();
              return;
              ((aumk)localObject2).b();
              return;
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682B", "0X800682B", 0, 0, "", "", "", "");
              if (aunv.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, "com.tencent.qqmusic"))
              {
                localObject1 = null;
                paramView = (View)localObject1;
                if (localObject2 != null) {}
                try
                {
                  paramView = ((aumk)localObject2).a();
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
                  azmj.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity.app, "CliOper", "", "", "0X800682C", "0X800682C", 0, 0, "", "", "", "");
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
            localObject1 = (bhpy)bhql.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity, null);
            ((bhpy)localObject1).a(2131694634);
            ((bhpy)localObject1).a(2131694636, 2);
            ((bhpy)localObject1).c(2131694633);
            ((bhpy)localObject1).a(new aunl(this, paramView, (bhpy)localObject1));
            ((bhpy)localObject1).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aunj
 * JD-Core Version:    0.7.0.1
 */