import android.app.Activity;
import com.tencent.qqmini.sdk.core.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.ui.MoreItem;

public class bgoj
{
  private InnerShareData a = new InnerShareData(null);
  
  public bgoj a(int paramInt)
  {
    this.a.shareSource = paramInt;
    return this;
  }
  
  public bgoj a(Activity paramActivity)
  {
    this.a.jdField_a_of_type_AndroidAppActivity = paramActivity;
    return this;
  }
  
  public bgoj a(EntryModel paramEntryModel)
  {
    this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel = paramEntryModel;
    return this;
  }
  
  public bgoj a(MiniAppInfo paramMiniAppInfo)
  {
    InnerShareData.a(this.a, paramMiniAppInfo);
    return this;
  }
  
  public bgoj a(ShareChatModel paramShareChatModel)
  {
    this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel = paramShareChatModel;
    return this;
  }
  
  public bgoj a(String paramString)
  {
    this.a.title = paramString;
    return this;
  }
  
  public bgoj a(boolean paramBoolean)
  {
    this.a.isLocalPic = paramBoolean;
    return this;
  }
  
  public InnerShareData a()
  {
    return this.a;
  }
  
  public bgoj b(int paramInt)
  {
    this.a.shareTarget = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (MoreItem.a(paramInt)) {
        c(paramInt);
      }
      return this;
      c(1);
      continue;
      c(2);
      continue;
      c(3);
      continue;
      c(4);
    }
  }
  
  public bgoj b(String paramString)
  {
    this.a.summary = paramString;
    return this;
  }
  
  public bgoj b(boolean paramBoolean)
  {
    this.a.shareInMiniProcess = paramBoolean;
    return this;
  }
  
  public bgoj c(int paramInt)
  {
    this.a.shareItemId = paramInt;
    return this;
  }
  
  public bgoj c(String paramString)
  {
    this.a.sharePicPath = paramString;
    return this;
  }
  
  public bgoj c(boolean paramBoolean)
  {
    this.a.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public bgoj d(String paramString)
  {
    this.a.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bgoj e(String paramString)
  {
    this.a.b = paramString;
    return this;
  }
  
  public bgoj f(String paramString)
  {
    this.a.c = paramString;
    return this;
  }
  
  public bgoj g(String paramString)
  {
    this.a.d = paramString;
    return this;
  }
  
  public bgoj h(String paramString)
  {
    this.a.e = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgoj
 * JD-Core Version:    0.7.0.1
 */