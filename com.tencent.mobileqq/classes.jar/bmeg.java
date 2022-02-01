import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.List;

class bmeg
  extends bkti
{
  bmeg(bmef parambmef, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_exit_room");
      ((bmeh)this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt == 0) || (paramInt == 1003)) {
      bmdn.a().b(this.jdField_a_of_type_Bmef.d, this.jdField_a_of_type_Boolean, this.b);
    }
    while ((this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("gmesdk_event_key", "gmesdk_event_key_enterroom");
    localBundle.putInt("gmesdk_event_ret", paramInt);
    localBundle.putString("gmesdk_event_value_eterroom_ret_msg", paramString);
    ((bmeh)this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
  }
  
  public void a(int paramInt, String[] paramArrayOfString)
  {
    int i = 0;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      paramInt = 0;
      String str;
      Bundle localBundle;
      while (paramInt < paramArrayOfString.length)
      {
        str = paramArrayOfString[paramInt];
        if ((this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
        {
          localBundle = new Bundle();
          localBundle.putString("gmesdk_event_key", "gmesdk_event_key_member_info");
          localBundle.putBoolean("gmesdk_event_key_member_speaking", false);
          localBundle.putString("gmesdk_event_key_member_uin", str);
          ((bmeh)this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
        }
        paramInt += 1;
      }
      continue;
      while (i < paramArrayOfString.length)
      {
        str = paramArrayOfString[i];
        if (!this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaUtilList.contains(str))
        {
          this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaUtilList.add(str);
          if ((this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
          {
            localBundle = new Bundle();
            localBundle.putString("gmesdk_event_key", "gmesdk_event_key_member_info");
            localBundle.putBoolean("gmesdk_event_key_member_speaking", true);
            localBundle.putString("gmesdk_event_key_member_uin", str);
            ((bmeh)this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
          }
        }
        i += 1;
      }
      continue;
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        str = paramArrayOfString[paramInt];
        if (this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaUtilList.contains(str))
        {
          this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaUtilList.remove(str);
          if ((this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
          {
            localBundle = new Bundle();
            localBundle.putString("gmesdk_event_key", "gmesdk_event_key_member_info");
            localBundle.putBoolean("gmesdk_event_key_member_speaking", false);
            localBundle.putString("gmesdk_event_key_member_uin", str);
            ((bmeh)this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle;
    if ((this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localBundle = new Bundle();
      if (!paramBoolean) {
        break label70;
      }
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_open_mic");
      localBundle.putInt("gmesdk_event_ret", paramInt);
    }
    for (;;)
    {
      ((bmeh)this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
      return;
      label70:
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_close_mic");
      localBundle.putInt("gmesdk_event_ret", paramInt);
    }
  }
  
  public void a(String[] paramArrayOfString) {}
  
  public void b(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_enterroom");
      localBundle.putInt("gmesdk_event_ret", paramInt);
      localBundle.putString("gmesdk_event_value_eterroom_ret_msg", paramString);
      ((bmeh)this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle;
    if ((this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localBundle = new Bundle();
      if (!paramBoolean) {
        break label70;
      }
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_open_speaker");
      localBundle.putInt("gmesdk_event_ret", paramInt);
    }
    for (;;)
    {
      ((bmeh)this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
      return;
      label70:
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_close_speaker");
      localBundle.putInt("gmesdk_event_ret", paramInt);
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_room_disconnect");
      localBundle.putInt("gmesdk_event_ret", paramInt);
      localBundle.putString("gmesdk_event_value_room_disconnect_ret_msg", paramString);
      ((bmeh)this.jdField_a_of_type_Bmef.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmeg
 * JD-Core Version:    0.7.0.1
 */