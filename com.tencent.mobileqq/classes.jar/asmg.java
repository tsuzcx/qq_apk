import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.AppFileMsgInfo;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.CheckShareExtensionReq;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.ImgInfo;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.TextInfo;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.VideoInfo;

public class asmg
{
  asmj a;
  public BaseActivity a;
  public WeakReference<asnb> a;
  public HashSet<String> a;
  
  public asmg(BaseActivity paramBaseActivity, asnb paramasnb)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_JavaUtilHashSet = bddr.a(paramBaseActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramasnb);
  }
  
  public Uri a(Bundle paramBundle)
  {
    paramBundle = paramBundle.get("android.intent.extra.STREAM");
    if (paramBundle != null)
    {
      if ((paramBundle instanceof Uri)) {
        return (Uri)paramBundle;
      }
      if ((paramBundle instanceof String)) {
        return Uri.parse((String)paramBundle);
      }
    }
    return null;
  }
  
  public ArrayList<String> a(Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    paramBundle = paramBundle.get("android.intent.extra.STREAM");
    if ((paramBundle != null) && ((paramBundle instanceof ArrayList)))
    {
      paramBundle = (ArrayList)paramBundle;
      asmj localasmj = new asmj(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false, null);
      int i = 0;
      while (i < paramBundle.size())
      {
        String str = localasmj.a((Uri)paramBundle.get(i), false);
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public oidb_cmd0xc78.CheckShareExtensionReq a()
  {
    oidb_cmd0xc78.CheckShareExtensionReq localCheckShareExtensionReq = new oidb_cmd0xc78.CheckShareExtensionReq();
    localCheckShareExtensionReq.uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()).longValue());
    if ((this.jdField_a_of_type_JavaUtilHashSet != null) && (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localCheckShareExtensionReq.android_package_names.add(str);
      }
    }
    int i = 0;
    if (asmi.a())
    {
      localCheckShareExtensionReq.user_flag1.set(1L);
      i = asmi.a();
      localCheckShareExtensionReq.user_flag2.set(i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("CheckForward.Security", 2, "setRequestCommonFiled flag =" + i + " ,pkg: ");
    }
    return localCheckShareExtensionReq;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CheckForward.Security", 2, "sendCheckTextShareReq text " + paramString);
    }
    asmy localasmy = (asmy)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(311);
    oidb_cmd0xc78.CheckShareExtensionReq localCheckShareExtensionReq = a();
    localCheckShareExtensionReq.content_type.set(1);
    oidb_cmd0xc78.TextInfo localTextInfo = new oidb_cmd0xc78.TextInfo();
    localTextInfo.text_content.set(paramString);
    localCheckShareExtensionReq.texts.add(localTextInfo);
    paramString = (asnb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString != null) {
      localasmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, localCheckShareExtensionReq, "android.intent.action.SEND", paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    asmy localasmy;
    oidb_cmd0xc78.CheckShareExtensionReq localCheckShareExtensionReq;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CheckForward.Security", 2, "sendCheckVideoShareReq path = " + paramString1 + ",action= " + paramString2);
      }
      localasmy = (asmy)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(311);
      localCheckShareExtensionReq = a();
      localCheckShareExtensionReq.content_type.set(3);
      if ((!TextUtils.isEmpty(paramString1)) && (new File(paramString1).exists()))
      {
        oidb_cmd0xc78.VideoInfo localVideoInfo = new oidb_cmd0xc78.VideoInfo();
        String str = bdcv.a(arni.d(paramString1));
        localVideoInfo.md5.set(str);
        long l = ShortVideoUtils.b(paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("CheckForward.Security", 2, "sendCheckVideoShareReq md5= " + str + ",du=" + l);
        }
        localVideoInfo.sha1.set(asmi.a(paramString1));
        localVideoInfo.play_duration.set((int)l);
        localCheckShareExtensionReq.videos.add(localVideoInfo);
      }
      paramString1 = (asnb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramString1 == null);
    localasmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, localCheckShareExtensionReq, paramString2, paramString1);
  }
  
  public void a(ArrayList<String> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    asmy localasmy;
    oidb_cmd0xc78.CheckShareExtensionReq localCheckShareExtensionReq;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CheckForward.Security", 2, "sendCheckImgShareReq path len= " + paramArrayList.size() + ", action=" + paramString);
      }
      localasmy = (asmy)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(311);
      localCheckShareExtensionReq = a();
      localCheckShareExtensionReq.content_type.set(2);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject2 = (String)paramArrayList.next();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          Object localObject1 = new File((String)localObject2);
          if (((File)localObject1).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("CheckForward.Security", 2, "sendCheckImgShareReq path " + (String)localObject2);
            }
            oidb_cmd0xc78.ImgInfo localImgInfo = new oidb_cmd0xc78.ImgInfo();
            String str = bdcv.a(arni.d((String)localObject2));
            if (QLog.isColorLevel()) {
              QLog.d("CheckForward.Security", 2, "sendCheckImgShareReq md5= " + str);
            }
            localImgInfo.md5.set(str);
            localImgInfo.sha1.set(asmi.a((String)localObject2));
            localObject2 = asmi.a((String)localObject2);
            if (localObject2 != null)
            {
              localImgInfo.width.set(((Integer)((Pair)localObject2).first).intValue());
              localImgInfo.height.set(((Integer)((Pair)localObject2).second).intValue());
            }
            localObject1 = asmi.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (File)localObject1);
            if (localObject1 != null)
            {
              if (!TextUtils.isEmpty((CharSequence)((Pair)localObject1).first)) {
                localImgInfo.qr_code_result.set(((StringBuilder)((Pair)localObject1).first).toString());
              }
              if (!TextUtils.isEmpty((CharSequence)((Pair)localObject1).second)) {
                localImgInfo.qr_decode_type.set(((StringBuilder)((Pair)localObject1).second).toString());
              }
            }
            localCheckShareExtensionReq.imgs.add(localImgInfo);
          }
        }
      }
      paramArrayList = (asnb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramArrayList == null);
    localasmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, localCheckShareExtensionReq, paramString, paramArrayList);
  }
  
  public boolean a(Intent paramIntent, String paramString)
  {
    for (int i = 3;; i = 4) {
      for (;;)
      {
        try
        {
          if (!asmt.a().d()) {
            return false;
          }
          Bundle localBundle = paramIntent.getExtras();
          String str = paramIntent.getType();
          if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString))) {
            break label405;
          }
          if ((paramString.equals("android.intent.action.SEND")) || (paramString.equals("android.intent.action.SEND_MULTIPLE")))
          {
            if ((str.startsWith("text/")) && (!localBundle.containsKey("android.intent.extra.STREAM")))
            {
              a(localBundle.getString("android.intent.extra.TEXT"));
              return true;
            }
            if (str.startsWith("message/"))
            {
              paramIntent = (SpannableString)localBundle.get("android.intent.extra.TEXT");
              if (paramIntent != null)
              {
                a(paramIntent.toString());
                return true;
              }
            }
            else if (str.startsWith("image/"))
            {
              if (paramString.equals("android.intent.action.SEND"))
              {
                paramIntent = a(localBundle);
                if ((paramIntent != null) && (a(paramIntent, 2, paramString))) {
                  return true;
                }
              }
              else
              {
                paramIntent = a(localBundle);
                if ((paramIntent != null) && (paramIntent.size() > 0))
                {
                  a(paramIntent, paramString);
                  return true;
                }
              }
            }
            else if (paramString.equals("android.intent.action.SEND"))
            {
              localBundle.get("android.intent.extra.STREAM");
              paramIntent = a(localBundle);
              if (paramIntent != null)
              {
                if (("text/x-vcard".equals(str)) && ("content".equals(paramIntent.getScheme()))) {
                  return false;
                }
                if (!str.startsWith("video/")) {
                  break;
                }
                if (a(paramIntent, i, paramString)) {
                  return true;
                }
              }
            }
            else
            {
              paramIntent = a(localBundle);
              if ((paramIntent != null) && (paramIntent.size() > 0))
              {
                b(paramIntent, paramString);
                return true;
              }
            }
          }
          else if (paramString.equals("android.intent.action.VIEW"))
          {
            paramIntent = paramIntent.getData();
            if (paramIntent == null) {
              return false;
            }
            if ((str != null) && (str.startsWith("image/")))
            {
              if (a(paramIntent, 2, paramString)) {
                return true;
              }
            }
            else
            {
              if (!str.startsWith("video/")) {
                break label395;
              }
              boolean bool = a(paramIntent, i, paramString);
              if (bool) {
                return true;
              }
            }
          }
        }
        catch (Throwable paramIntent)
        {
          QLog.e("CheckForward.Security", 1, "system share.prepareSecurityCheck exception=", paramIntent);
        }
        return false;
        label395:
        i = 4;
      }
    }
    label405:
    return false;
  }
  
  public boolean a(Uri paramUri, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Asmj == null) {
      this.jdField_a_of_type_Asmj = new asmj(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false, new asmh(this, paramInt, paramString));
    }
    String str = this.jdField_a_of_type_Asmj.a(paramUri);
    QLog.d("CheckForward.Security", 1, "system share.prepareFileInfoAndReq : uri= " + paramUri + ", path= " + str);
    if (TextUtils.isEmpty(str)) {}
    long l;
    do
    {
      return false;
      if ((this.jdField_a_of_type_Asmj.b) || (this.jdField_a_of_type_Asmj.a)) {
        return true;
      }
      paramUri = new File(str);
      l = paramUri.length();
    } while ((!this.jdField_a_of_type_Asmj.b) && (!this.jdField_a_of_type_Asmj.a) && (l == 0L));
    if ((arvk.b(str)) || (!paramUri.canRead()))
    {
      QLog.d("CheckForward.Security", 1, "system share.prepareFileInfoAndReq : can not Read");
      return false;
    }
    if (paramInt == 2)
    {
      paramUri = new ArrayList();
      paramUri.add(str);
      a(paramUri, paramString);
    }
    for (;;)
    {
      return true;
      if (paramInt == 4)
      {
        paramUri = new ArrayList();
        paramUri.add(str);
        b(paramUri, paramString);
      }
      else if (paramInt == 3)
      {
        a(str, paramString);
      }
    }
  }
  
  public void b(ArrayList<String> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    asmy localasmy;
    oidb_cmd0xc78.CheckShareExtensionReq localCheckShareExtensionReq;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CheckForward.Security", 2, "sendCheckFileShareReq path len= " + paramArrayList.size() + ", action=" + paramString);
      }
      localasmy = (asmy)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(311);
      localCheckShareExtensionReq = a();
      localCheckShareExtensionReq.content_type.set(4);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str1 = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str1))
        {
          File localFile = new File(str1);
          if (localFile.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("CheckForward.Security", 2, "sendCheckFileShareReq path " + str1);
            }
            oidb_cmd0xc78.AppFileMsgInfo localAppFileMsgInfo = new oidb_cmd0xc78.AppFileMsgInfo();
            String str2 = bdcv.a(arni.d(str1));
            if (QLog.isColorLevel()) {
              QLog.d("CheckForward.Security", 2, "sendCheckFileShareReq md5= " + str2);
            }
            localAppFileMsgInfo.md5.set(str2);
            localAppFileMsgInfo.sha1.set(asmi.a(str1));
            localAppFileMsgInfo.file_size.set((int)localFile.length());
            localCheckShareExtensionReq.files.add(localAppFileMsgInfo);
          }
        }
      }
      paramArrayList = (asnb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramArrayList == null);
    localasmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, localCheckShareExtensionReq, paramString, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmg
 * JD-Core Version:    0.7.0.1
 */