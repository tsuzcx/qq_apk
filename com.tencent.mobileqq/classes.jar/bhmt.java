import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

class bhmt
  extends ascz
{
  bhmt(bhmn parambhmn) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle arg1)
  {
    if (???.getInt("srcType") != 5) {}
    int i;
    int j;
    label280:
    label464:
    label614:
    do
    {
      do
      {
        long l;
        do
        {
          for (;;)
          {
            return;
            String str1 = ???.getString("status");
            l = ???.getLong("id");
            i = ???.getInt("progress");
            boolean bool = ???.getBoolean("result");
            j = ???.getInt("resourceType");
            String str2 = ???.getString("colorType");
            if (QLog.isColorLevel()) {
              QLog.d("ColorRingPlayer", 2, "onPushMsg," + l + "," + j + "," + str1 + "," + i + "," + bool);
            }
            synchronized (this.a.jdField_a_of_type_Bhmu)
            {
              if (this.a.jdField_a_of_type_Bhmu.jdField_a_of_type_Long != l)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ColorRingPlayer", 2, "curId=" + this.a.jdField_a_of_type_Bhmu.jdField_a_of_type_Long + ", pushId=" + l);
                }
                return;
              }
            }
            if (!"onStart".equals(localObject1))
            {
              if (!"onDone".equals(localObject1)) {
                break label614;
              }
              if (!bool) {
                break label464;
              }
              if (j == 3)
              {
                if ("colorring".equals(str2))
                {
                  this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131718539));
                  this.a.c.setImageDrawable(this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847094));
                  this.a.c.setVisibility(0);
                  this.a.b.setVisibility(8);
                }
                synchronized (this.a.jdField_a_of_type_Bhmu)
                {
                  this.a.jdField_a_of_type_Bhmu.jdField_a_of_type_Int = 3;
                  if (this.a.jdField_a_of_type_Boolean)
                  {
                    this.a.a(l, 0);
                    return;
                    if (!"comering".equals(str2)) {
                      break label280;
                    }
                    this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131718540));
                  }
                }
              }
            }
          }
          if (j == 2)
          {
            this.a.a(bhml.a(l));
            return;
          }
        } while ((j != 1) || (bhml.a(l) == null));
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(bhml.a(l));
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ColorRingPlayer", 2, "onDone, failure," + l + "," + j);
        }
      } while (j != 3);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131690904));
      this.a.c.setImageDrawable(this.a.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847092));
      this.a.c.setVisibility(0);
      this.a.b.setVisibility(8);
      synchronized (this.a.jdField_a_of_type_Bhmu)
      {
        this.a.jdField_a_of_type_Bhmu.jdField_a_of_type_Int = 0;
        return;
      }
    } while ((!"onProgress".equals(localObject3)) || (j != 3) || (this.a.jdField_a_of_type_Biqx == null));
    this.a.jdField_a_of_type_Biqx.setLevel(i * 100);
    this.a.jdField_a_of_type_Biqx.invalidateSelf();
  }
  
  public void onResponse(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmt
 * JD-Core Version:    0.7.0.1
 */