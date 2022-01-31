import android.app.Activity;
import com.tencent.qqmini.sdk.core.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.ui.MoreItem;

public class bgkc
{
  private InnerShareData a = new InnerShareData(null);
  
  public bgkc a(int paramInt)
  {
    this.a.shareSource = paramInt;
    return this;
  }
  
  public bgkc a(Activity paramActivity)
  {
    this.a.jdField_a_of_type_AndroidAppActivity = paramActivity;
    return this;
  }
  
  public bgkc a(EntryModel paramEntryModel)
  {
    this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel = paramEntryModel;
    return this;
  }
  
  public bgkc a(MiniAppInfo paramMiniAppInfo)
  {
    InnerShareData.a(this.a, paramMiniAppInfo);
    return this;
  }
  
  public bgkc a(ShareChatModel paramShareChatModel)
  {
    this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel = paramShareChatModel;
    return this;
  }
  
  public bgkc a(String paramString)
  {
    this.a.title = paramString;
    return this;
  }
  
  public bgkc a(boolean paramBoolean)
  {
    this.a.isLocalPic = paramBoolean;
    return this;
  }
  
  public InnerShareData a()
  {
    return this.a;
  }
  
  public bgkc b(int paramInt)
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
  
  public bgkc b(String paramString)
  {
    this.a.summary = paramString;
    return this;
  }
  
  public bgkc b(boolean paramBoolean)
  {
    this.a.shareInMiniProcess = paramBoolean;
    return this;
  }
  
  public bgkc c(int paramInt)
  {
    this.a.shareItemId = paramInt;
    return this;
  }
  
  public bgkc c(String paramString)
  {
    this.a.sharePicPath = paramString;
    return this;
  }
  
  public bgkc c(boolean paramBoolean)
  {
    this.a.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public bgkc d(String paramString)
  {
    this.a.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bgkc e(String paramString)
  {
    this.a.b = paramString;
    return this;
  }
  
  public bgkc f(String paramString)
  {
    this.a.c = paramString;
    return this;
  }
  
  public bgkc g(String paramString)
  {
    this.a.d = paramString;
    return this;
  }
  
  public bgkc h(String paramString)
  {
    this.a.e = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgkc
 * JD-Core Version:    0.7.0.1
 */