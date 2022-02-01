package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.comic.api.IQQComicConfigApi;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.galleryactivity.AbstractAnimationManager;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.OnGestureChangeListener;
import com.tencent.widget.Gallery;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class AIOGallerySceneWithBusiness
  extends AIOGalleryScene
  implements DragView.OnGestureChangeListener
{
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  private AIORichMediaInfo jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  Button b;
  Button c;
  Button d;
  TextView f;
  TextView g;
  boolean w = false;
  
  public AIOGallerySceneWithBusiness(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel, paramIAIOImageProvider, paramString);
  }
  
  private void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "cancleProgressDailog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
        this.jdField_a_of_type_AndroidAppProgressDialog = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static int a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length >= 8))
    {
      if (paramArrayOfString[7].equals("link")) {
        return 3;
      }
      if ((paramArrayOfString.length >= 9) && (paramArrayOfString[7].equals("scrawl_link")))
      {
        paramArrayOfString = paramArrayOfString[8];
        if (!TextUtils.isEmpty(paramArrayOfString))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("name = ");
            localStringBuilder.append(paramArrayOfString);
            localStringBuilder.append(" , name.length = ");
            localStringBuilder.append(paramArrayOfString.length());
            QLog.i("AIOImageData", 2, localStringBuilder.toString());
          }
          if ((!paramArrayOfString.startsWith("upload")) && (paramArrayOfString.trim().length() <= 32)) {
            return 3;
          }
        }
      }
      return 1;
    }
    return 0;
  }
  
  public static String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg != null) && ((paramChatMessage.structingMsg instanceof StructMsgForImageShare))) {
        return a((StructMsgForImageShare)paramChatMessage.structingMsg);
      }
    }
    return null;
  }
  
  public static String a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramStructMsgForImageShare != null)
    {
      if (a(paramStructMsgForImageShare.mMsgActionData))
      {
        if ((!TextUtils.isEmpty(paramStructMsgForImageShare.mMsg_A_ActionData)) && (paramStructMsgForImageShare.mMsg_A_ActionData.indexOf("|") > 0))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("comic_plugin.apk|");
          ((StringBuilder)localObject1).append(paramStructMsgForImageShare.mMsg_A_ActionData);
          return ((StringBuilder)localObject1).toString();
        }
        return paramStructMsgForImageShare.mMsgActionData;
      }
      localObject1 = localObject2;
      if (b(paramStructMsgForImageShare.mMsgActionData)) {
        localObject1 = paramStructMsgForImageShare.mMsgActionData;
      }
    }
    return localObject1;
  }
  
  public static String a(String paramString)
  {
    if (a(paramString))
    {
      paramString = paramString.substring(paramString.indexOf("|") + 1).split("\\|");
      if (paramString.length >= 8)
      {
        if (paramString[7].equals("link")) {
          return paramString[4];
        }
        if ((paramString[7].equals("scrawl_link")) && (paramString.length >= 9)) {
          return paramString[8];
        }
      }
    }
    return "";
  }
  
  private void a(AIOImageData paramAIOImageData)
  {
    paramAIOImageData = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
    b(paramAIOImageData);
    Object localObject = b(paramAIOImageData.mMsgActionData);
    if ((localObject != null) && (localObject.length > 2))
    {
      paramAIOImageData = Uri.parse(localObject[1]);
      try
      {
        paramAIOImageData = paramAIOImageData.getQueryParameter("article_id");
      }
      catch (Exception paramAIOImageData)
      {
        paramAIOImageData.printStackTrace();
        paramAIOImageData = "";
      }
      if (paramAIOImageData == null) {
        paramAIOImageData = "";
      }
      if (localObject.length > 3)
      {
        localObject = localObject[3];
        if ((localObject != null) && (((String)localObject).equals("1"))) {
          break label107;
        }
      }
      localObject = "";
      label107:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007130", "0X8007130", 0, 0, paramAIOImageData, (String)localObject, "", "");
    }
  }
  
  private void a(AIOImageData paramAIOImageData, StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramAIOImageData.b == 2)
    {
      paramStructMsgForImageShare = b(paramStructMsgForImageShare.mMsgActionData);
      if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.length > 2))
      {
        paramAIOImageData = Uri.parse(paramStructMsgForImageShare[1]);
        try
        {
          paramAIOImageData = paramAIOImageData.getQueryParameter("article_id");
        }
        catch (Exception paramAIOImageData)
        {
          paramAIOImageData.printStackTrace();
          paramAIOImageData = "";
        }
        if (paramAIOImageData == null) {
          paramAIOImageData = "";
        }
        if (paramStructMsgForImageShare.length > 3)
        {
          paramStructMsgForImageShare = paramStructMsgForImageShare[3];
          if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.equals("1"))) {
            break label93;
          }
        }
        paramStructMsgForImageShare = "";
        label93:
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007131", "0X8007131", 0, 0, paramAIOImageData, paramStructMsgForImageShare, "", "");
      }
    }
  }
  
  private void a(AIOImageData paramAIOImageData, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = "";
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
    String[] arrayOfString = b(localStructMsgForImageShare.mMsgActionData);
    if ((arrayOfString != null) && (arrayOfString.length > 2))
    {
      Object localObject = arrayOfString[2];
      paramAIOImageData = (AIOImageData)localObject;
      if (localObject != null)
      {
        paramAIOImageData = (AIOImageData)localObject;
        if (((String)localObject).length() > 17)
        {
          paramAIOImageData = new StringBuilder();
          paramAIOImageData.append(((String)localObject).substring(0, 16));
          paramAIOImageData.append("...");
          paramAIOImageData = paramAIOImageData.toString();
        }
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(paramAIOImageData);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (paramBoolean1)
      {
        paramAIOImageData = Uri.parse(arrayOfString[1]);
        try
        {
          paramAIOImageData = paramAIOImageData.getQueryParameter("article_id");
        }
        catch (Exception paramAIOImageData)
        {
          paramAIOImageData.printStackTrace();
          paramAIOImageData = "";
        }
        localObject = paramAIOImageData;
        if (paramAIOImageData == null) {
          localObject = "";
        }
        paramAIOImageData = str1;
        if (arrayOfString.length > 3)
        {
          String str2 = arrayOfString[3];
          paramAIOImageData = str1;
          if (str2 != null) {
            if (!str2.equals("1")) {
              paramAIOImageData = str1;
            } else {
              paramAIOImageData = str2;
            }
          }
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007153", "0X8007153", 0, 0, (String)localObject, paramAIOImageData, "", "");
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8007153", "", (String)localObject, paramAIOImageData, "", "");
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    paramAIOImageData = this.f;
    if (paramAIOImageData != null)
    {
      paramAIOImageData.setText(HardCodeUtil.a(2131700261));
      if ((arrayOfString != null) && (arrayOfString.length > 3))
      {
        paramAIOImageData = arrayOfString[3];
        if ((paramAIOImageData != null) && (paramAIOImageData.equals("1"))) {
          this.f.setText(HardCodeUtil.a(2131700295));
        }
      }
    }
    this.jdField_a_of_type_AndroidViewView.invalidate();
    this.jdField_a_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare);
    this.jdField_b_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare);
    this.c.setTag(localStructMsgForImageShare);
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, AIOImageData paramAIOImageData, boolean paramBoolean)
  {
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
    String[] arrayOfString = a(localStructMsgForImageShare);
    String str1 = null;
    if ((arrayOfString != null) && (arrayOfString.length >= 8))
    {
      String str2 = arrayOfString[1];
      paramAIOImageData = new StringBuilder();
      paramAIOImageData.append(arrayOfString[3]);
      paramAIOImageData.append(HardCodeUtil.a(2131700282));
      paramAIOImageData.append(arrayOfString[5]);
      paramAIOImageData.append(HardCodeUtil.a(2131700297));
      str1 = paramAIOImageData.toString();
      paramAIOImageData = str2;
      if (str2 != null)
      {
        paramAIOImageData = str2;
        if (str2.length() >= 7)
        {
          paramAIOImageData = new StringBuilder();
          paramAIOImageData.append(str2.substring(0, 6));
          paramAIOImageData.append("...");
          paramAIOImageData = paramAIOImageData.toString();
        }
      }
      if (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramAIORichMediaInfo.hashCode())))
      {
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "3008", "1", "30004", arrayOfString[0], new String[] { arrayOfString[2], arrayOfString[4], a(localStructMsgForImageShare.mMsgActionData) });
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramAIORichMediaInfo.hashCode()));
      }
      paramAIORichMediaInfo = paramAIOImageData;
      paramAIOImageData = str1;
    }
    else
    {
      paramAIOImageData = null;
      paramAIORichMediaInfo = str1;
    }
    if (TextUtils.isEmpty(paramAIORichMediaInfo))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(paramAIORichMediaInfo);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    if (TextUtils.isEmpty(paramAIOImageData))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetButton.setText(paramAIOImageData);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    }
    paramAIORichMediaInfo = this.f;
    if (paramAIORichMediaInfo != null) {
      paramAIORichMediaInfo.setText(HardCodeUtil.a(2131700257));
    }
    if ((arrayOfString != null) && (arrayOfString.length >= 8))
    {
      paramAIORichMediaInfo = this.f;
      if (paramAIORichMediaInfo != null) {
        paramAIORichMediaInfo.setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidViewView.invalidate();
    this.jdField_a_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare);
    this.jdField_b_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare);
    this.c.setTag(localStructMsgForImageShare);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void a(boolean paramBoolean, String[] paramArrayOfString, StructMsgForImageShare paramStructMsgForImageShare, File paramFile)
  {
    if (paramBoolean)
    {
      if ((paramArrayOfString[7].equals("scrawl_link")) && (paramArrayOfString.length > 8)) {
        str1 = paramArrayOfString[8];
      } else {
        str1 = null;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramArrayOfString[3]);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131700265));
      ((StringBuilder)localObject).append(paramArrayOfString[5]);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131700277));
      String str3 = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ADTAG=comic.plugin.read&id=");
      ((StringBuilder)localObject).append(paramArrayOfString[0]);
      ((StringBuilder)localObject).append("&name=");
      ((StringBuilder)localObject).append(URLEncoder.encode(paramArrayOfString[1]));
      ((StringBuilder)localObject).append("&sectionID=");
      ((StringBuilder)localObject).append(paramArrayOfString[2]);
      ((StringBuilder)localObject).append("&sectionName=");
      ((StringBuilder)localObject).append(URLEncoder.encode(paramArrayOfString[3]));
      ((StringBuilder)localObject).append("&pageID=");
      ((StringBuilder)localObject).append(paramArrayOfString[4]);
      ((StringBuilder)localObject).append("&page=");
      ((StringBuilder)localObject).append(paramArrayOfString[5]);
      ((StringBuilder)localObject).append("&type=");
      ((StringBuilder)localObject).append(paramArrayOfString[6]);
      String str2 = ((StringBuilder)localObject).toString();
      localObject = str2;
      if (!TextUtils.isEmpty(str1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append("&scrawl_link=");
        ((StringBuilder)localObject).append(URLEncoder.encode(str1));
        localObject = ((StringBuilder)localObject).toString();
      }
      String str1 = ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).getUrl("comicReadShare", "5123", null, null, "354", null, (String)localObject);
      new QfavBuilder(6).a("nLinkType", 0).b("sTitle", paramArrayOfString[1]).b("sUrl", str1).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", paramStructMsgForImageShare.mSourceName).b("sBrief", str3).b("sPath", paramFile.getAbsolutePath()).b("sResUrl", paramStructMsgForImageShare.mSourceUrl).a("lCategory", 1L).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString);
      QfavReport.a(null, 6, 2);
      if (paramArrayOfString.length >= 8)
      {
        if (paramArrayOfString[7].equals("link"))
        {
          paramStructMsgForImageShare = paramArrayOfString[4];
          break label496;
        }
        if ((paramArrayOfString[7].equals("scrawl_link")) && (paramArrayOfString.length >= 9))
        {
          paramStructMsgForImageShare = paramArrayOfString[8];
          break label496;
        }
      }
      paramStructMsgForImageShare = "";
      label496:
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", paramArrayOfString[0], new String[] { "2", "", paramStructMsgForImageShare });
    }
  }
  
  private void a(String[] paramArrayOfString, StructMsgForImageShare paramStructMsgForImageShare)
  {
    String str = paramArrayOfString[1];
    Object localObject = paramArrayOfString[2];
    localObject = paramStructMsgForImageShare.getFirstImageElement();
    if (localObject != null)
    {
      if (((StructMsgItemImage)localObject).a == null) {
        ((StructMsgItemImage)localObject).a = paramStructMsgForImageShare;
      }
      AIOImageData localAIOImageData = AIOGalleryUtils.a(((StructMsgItemImage)localObject).a());
      localObject = localAIOImageData.a(4);
      paramStructMsgForImageShare = (StructMsgForImageShare)localObject;
      if (localObject == null) {
        paramStructMsgForImageShare = localAIOImageData.a(2);
      }
      if (paramStructMsgForImageShare != null) {
        paramStructMsgForImageShare.getAbsolutePath();
      }
    }
    QfavBuilder.a(str).c(this.jdField_b_of_type_JavaLangString).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString);
    QfavReport.a(null, 6, 2);
    paramStructMsgForImageShare = Uri.parse(paramArrayOfString[1]);
    try
    {
      paramStructMsgForImageShare = paramStructMsgForImageShare.getQueryParameter("article_id");
    }
    catch (Exception paramStructMsgForImageShare)
    {
      paramStructMsgForImageShare.printStackTrace();
      paramStructMsgForImageShare = "";
    }
    if (paramStructMsgForImageShare == null) {
      paramStructMsgForImageShare = "";
    }
    if (paramArrayOfString.length > 3)
    {
      paramArrayOfString = paramArrayOfString[3];
      if ((paramArrayOfString != null) && (paramArrayOfString.equals("1"))) {
        break label166;
      }
    }
    paramArrayOfString = "";
    label166:
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007132", "0X8007132", 0, 0, paramStructMsgForImageShare, paramArrayOfString, "", "");
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("comic_plugin.apk"));
  }
  
  public static final String[] a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if ((paramStructMsgForImageShare.mMsgActionData != null) && (paramStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
    {
      String[] arrayOfString2 = paramStructMsgForImageShare.mMsgActionData.substring(paramStructMsgForImageShare.mMsgActionData.indexOf("|") + 1).split("\\|");
      int i;
      if ((arrayOfString2.length >= 8) && ((arrayOfString2[7].equals("link")) || (arrayOfString2[7].equals("scrawl_link")))) {
        i = 1;
      } else {
        i = 0;
      }
      String[] arrayOfString1 = arrayOfString2;
      int j = i;
      if (i == 0)
      {
        arrayOfString1 = arrayOfString2;
        j = i;
        if (!TextUtils.isEmpty(paramStructMsgForImageShare.mMsg_A_ActionData))
        {
          arrayOfString1 = paramStructMsgForImageShare.mMsg_A_ActionData.split("\\|");
          if ((arrayOfString1.length >= 8) && (arrayOfString1[7].equals("link"))) {
            j = 1;
          } else {
            j = 0;
          }
        }
      }
      if (j != 0) {
        return arrayOfString1;
      }
    }
    return null;
  }
  
  public static String[] a(String paramString)
  {
    if (a(paramString)) {
      return paramString.substring(paramString.indexOf("|") + 1).split("\\|");
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    if (a(paramString))
    {
      paramString = paramString.substring(paramString.indexOf("|") + 1).split("\\|");
      if ((paramString.length >= 8) && ((paramString[7].equals("link")) || (paramString[7].equals("scrawl_link")))) {
        return paramString[0];
      }
    }
    return "";
  }
  
  private void b(StructMsgForImageShare paramStructMsgForImageShare)
  {
    paramStructMsgForImageShare = b(paramStructMsgForImageShare.mMsgActionData);
    if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.length > 2))
    {
      paramStructMsgForImageShare = paramStructMsgForImageShare[1];
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidAppActivity, "/pubaccount/browser");
      localActivityURIRequest.extra().putString("uin", this.jdField_b_of_type_JavaLangString);
      localActivityURIRequest.extra().putString("url", paramStructMsgForImageShare);
      QRoute.startUri(localActivityURIRequest, null);
    }
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("ScreenShotShare"));
  }
  
  public static String[] b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.split("\\|");
    }
    return null;
  }
  
  public AIORichMediaInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 19002)
    {
      if (paramInt2 == -1) {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramIntent);
      }
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    if (paramInt1 == 19000) {
      return;
    }
    if (paramInt1 == 19005) {
      return;
    }
    if (paramInt1 == 103) {
      return;
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    if ((Build.VERSION.SDK_INT >= 21) && (!OSUtils.isEMUI3_1()))
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindow().clearFlags(67108864);
      this.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(-2147483648);
      this.jdField_a_of_type_AndroidAppActivity.getWindow().setStatusBarColor(0);
      this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    paramViewGroup = (RelativeLayout)a();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131563031, null);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 72.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380924));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380925));
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.c = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380922));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380926));
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    localObject = new AIOGallerySceneWithBusiness.1(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
    this.c.setOnClickListener((View.OnClickListener)localObject);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.g = ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).getSourceInGallery(this.jdField_a_of_type_AndroidAppActivity, paramViewGroup);
    this.g.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365892));
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b.getThumbRect());
  }
  
  protected void a(AIORichMediaInfo paramAIORichMediaInfo, Activity paramActivity, int paramInt)
  {
    if ((this.k != 1) && (this.k != 2) && (this.k != 3) && (this.k != 5) && (this.k != 6))
    {
      super.a(paramAIORichMediaInfo, paramActivity, paramInt);
      return;
    }
    if (!AIOImageData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
      return;
    }
    AIOImageData localAIOImageData = (AIOImageData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    int i = 4;
    File localFile = localAIOImageData.a(4);
    if (localFile == null)
    {
      localFile = localAIOImageData.a(2);
      paramInt = 0;
    }
    else
    {
      paramInt = 1;
    }
    Bundle localBundle = new Bundle(paramActivity.getIntent().getExtras());
    localBundle.putInt("forward_type", 1);
    localBundle.putBoolean("forward_urldrawable", true);
    localBundle.putString("forward_urldrawable_thumb_url", localAIOImageData.a(1));
    paramAIORichMediaInfo = paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (paramInt == 0) {
      i = 2;
    }
    localBundle.putString("forward_urldrawable_big_url", paramAIORichMediaInfo.a(i));
    if (localFile != null) {}
    try
    {
      localBundle.putString("forward_filepath", localFile.getAbsolutePath());
      localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      if (paramInt != 0) {
        localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
      }
      localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOImageData);
      localBundle.putBoolean("key_help_forward_pic", true);
      localBundle.putBoolean("key_allow_multiple_forward_from_limit", false);
      paramAIORichMediaInfo = new Intent();
      paramAIORichMediaInfo.putExtras(localBundle);
      ForwardBaseOption.a(paramActivity, paramAIORichMediaInfo, 19005);
      return;
    }
    catch (NullPointerException paramAIORichMediaInfo)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("showFriendPickerForForward ,NullPointerException: ");
      paramActivity.append(paramAIORichMediaInfo);
      QLog.d("AIOGalleryScene", 2, paramActivity.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,cache path is null");
    }
    return;
  }
  
  protected void a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare == null) {
      return;
    }
    Object localObject2 = paramStructMsgForImageShare.getFirstImageElement();
    if (localObject2 != null)
    {
      if (((StructMsgItemImage)localObject2).a == null) {
        ((StructMsgItemImage)localObject2).a = paramStructMsgForImageShare;
      }
      Object localObject1 = ((StructMsgItemImage)localObject2).a();
      URLDrawable localURLDrawable = ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity, (MessageForPic)localObject1);
      if (new File(((MessageForPic)localObject1).path).exists())
      {
        ((StructMsgItemImage)localObject2).ac = ((MessageForPic)localObject1).path;
      }
      else
      {
        String str = localURLDrawable.getURL().toString();
        if (AbsDownloader.hasFile(str))
        {
          localObject1 = AbsDownloader.getFile(str);
          if (localObject1 != null)
          {
            localObject1 = ((File)localObject1).getAbsolutePath();
            break label146;
          }
        }
        else
        {
          localObject1 = URLDrawableHelper.getURL((PicUiInterface)localObject1, 65537);
          if (localObject1 != null)
          {
            localObject1 = AbsDownloader.getFile(((URL)localObject1).toString());
            if ((localObject1 != null) && (((File)localObject1).exists()))
            {
              localObject1 = ((File)localObject1).getAbsolutePath();
              break label146;
            }
          }
        }
        localObject1 = null;
        label146:
        ((StructMsgItemImage)localObject2).ac = ((String)localObject1);
      }
      if (TextUtils.isEmpty(((StructMsgItemImage)localObject2).ac))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
        }
        return;
      }
      if (!AbsDownloader.hasFile(localURLDrawable.getURL().toString())) {
        localURLDrawable.startDownload();
      }
      localObject1 = new Bundle();
      if ((paramStructMsgForImageShare.source_puin != null) && (!"".equals(paramStructMsgForImageShare.source_puin))) {
        ((Bundle)localObject1).putString("source_puin", paramStructMsgForImageShare.source_puin);
      }
      ((Bundle)localObject1).putInt("forward_type", -3);
      paramStructMsgForImageShare.mCommentText = null;
      ((Bundle)localObject1).putInt("structmsg_service_id", paramStructMsgForImageShare.mMsgServiceID);
      ((Bundle)localObject1).putByteArray("stuctmsg_bytes", paramStructMsgForImageShare.getBytes());
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 0);
      localObject1 = a(paramStructMsgForImageShare);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        if (localObject1.length >= 8)
        {
          if (localObject1[7].equals("link"))
          {
            paramStructMsgForImageShare = localObject1[4];
            break label364;
          }
          if ((localObject1[7].equals("scrawl_link")) && (localObject1.length >= 9))
          {
            paramStructMsgForImageShare = localObject1[8];
            break label364;
          }
        }
        paramStructMsgForImageShare = "";
        label364:
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", localObject1[0], new String[] { "1", "", paramStructMsgForImageShare });
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
    }
  }
  
  protected void a(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    paramStructMsgForImageShare = a(paramStructMsgForImageShare);
    String str;
    if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.length > 0)) {
      str = paramStructMsgForImageShare[0];
    } else {
      str = "";
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("from", "13");
      localJSONObject.put("jumpto", "com.qqcomic.activity.VipComicMainTabActivity");
      localJSONObject.put("leftViewText", HardCodeUtil.a(2131700276));
      localJSONObject.put("maintab", "index");
      label100:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqqapi://qqcomic/jump?options=");
      localStringBuilder.append(localJSONObject.toString());
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.length >= 8))
      {
        if (paramStructMsgForImageShare[7].equals("link"))
        {
          paramStructMsgForImageShare = paramStructMsgForImageShare[4];
          break label212;
        }
        if ((paramStructMsgForImageShare[7].equals("scrawl_link")) && (paramStructMsgForImageShare.length >= 9))
        {
          paramStructMsgForImageShare = paramStructMsgForImageShare[8];
          break label212;
        }
      }
      paramStructMsgForImageShare = "";
      label212:
      if ("5".equals(paramString))
      {
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40057", str, new String[] { "", "", paramStructMsgForImageShare });
        return;
      }
      if ("6".equals(paramString)) {
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", str, new String[] { "4", "", paramStructMsgForImageShare });
      }
      return;
    }
    catch (Exception localException)
    {
      break label100;
    }
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (paramAIORichMediaInfo == null) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
    boolean bool1;
    if ((localObject != null) && (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = paramAIORichMediaInfo;
    boolean bool2;
    if ((this.jdField_b_of_type_AndroidWidgetImageButton.getVisibility() == 4) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    if (AIOImageData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject = (AIOImageData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (((AIOImageData)localObject).b == 1)
      {
        a(paramAIORichMediaInfo, (AIOImageData)localObject, bool2);
      }
      else if (((AIOImageData)localObject).b == 2)
      {
        a((AIOImageData)localObject, bool1, bool2);
      }
      else if (((AIOImageData)localObject).b == 5)
      {
        ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).updateSourceInGallery(this.g, this.jdField_a_of_type_AndroidAppActivity, localObject, this);
      }
      else if (bool2)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
    paramAIORichMediaInfo = this.jdField_d_of_type_AndroidWidgetButton;
    if (paramAIORichMediaInfo != null) {
      paramAIORichMediaInfo.setVisibility(4);
    }
    return true;
  }
  
  boolean a(ActionSheet paramActionSheet, AIOImageData paramAIOImageData)
  {
    if (paramActionSheet != null)
    {
      if (paramAIOImageData == null) {
        return false;
      }
      if (paramAIOImageData.b == 1)
      {
        paramActionSheet.addButton(2131693256);
        paramActionSheet.addButton(2131693254);
        paramActionSheet.addButton(2131693252);
        paramActionSheet.addButton(2131693251);
        return true;
      }
      if (paramAIOImageData.b == 2)
      {
        paramActionSheet.addButton(2131693254);
        paramActionSheet.addButton(2131693256);
        paramActionSheet.addButton(2131693249);
        paramAIOImageData = b(((StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a)).mMsgActionData);
        if ((paramAIOImageData != null) && (paramAIOImageData.length > 2))
        {
          paramActionSheet = Uri.parse(paramAIOImageData[1]);
          try
          {
            paramActionSheet = paramActionSheet.getQueryParameter("article_id");
          }
          catch (Exception paramActionSheet)
          {
            paramActionSheet.printStackTrace();
            paramActionSheet = "";
          }
          if (paramActionSheet == null) {
            paramActionSheet = "";
          }
          if (paramAIOImageData.length > 3)
          {
            paramAIOImageData = paramAIOImageData[3];
            if ((paramAIOImageData != null) && (paramAIOImageData.equals("1"))) {
              break label177;
            }
          }
          paramAIOImageData = "";
          label177:
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007154", "0X8007154", 0, 0, paramActionSheet, paramAIOImageData, "", "");
        }
        return true;
      }
    }
    return false;
  }
  
  boolean a(String paramString, AIOImageData paramAIOImageData, File paramFile)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramString != null) && (paramAIOImageData != null))
    {
      if (paramFile == null) {
        return false;
      }
      if (paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131693256)))
      {
        if ((paramAIOImageData.b == 1) || (paramAIOImageData.b == 2))
        {
          paramString = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
          a(paramString);
          a(paramAIOImageData, paramString);
          return true;
        }
      }
      else if (paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131693254)))
      {
        boolean bool1;
        if (paramAIOImageData.b == 1)
        {
          paramString = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
          paramAIOImageData = a(paramString);
          bool1 = bool2;
          if (paramAIOImageData != null)
          {
            bool1 = bool2;
            if (paramAIOImageData.length >= 8) {
              if (!paramAIOImageData[7].equals("link"))
              {
                bool1 = bool2;
                if (!paramAIOImageData[7].equals("scrawl_link")) {}
              }
              else
              {
                bool1 = true;
              }
            }
          }
          a(bool1, paramAIOImageData, paramString, paramFile);
        }
        else
        {
          if (paramAIOImageData.b != 2) {
            break label402;
          }
          paramString = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
          paramAIOImageData = b(paramString.mMsgActionData);
          bool1 = bool3;
          if (paramAIOImageData != null)
          {
            bool1 = bool3;
            if (paramAIOImageData.length > 2)
            {
              a(paramAIOImageData, paramString);
              bool1 = true;
            }
          }
        }
        return bool1;
      }
      else if (paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131693252)))
      {
        if (paramAIOImageData.b == 1)
        {
          b((StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a), "6");
          return true;
        }
      }
      else if (paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131693251)))
      {
        if (paramAIOImageData.b == 1)
        {
          a((StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a), "6");
          return true;
        }
      }
      else if ((paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131693249))) && (paramAIOImageData.b == 2))
      {
        a(paramAIOImageData);
        return true;
      }
      label402:
      return false;
    }
    return false;
  }
  
  protected void b(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    String[] arrayOfString = a(paramStructMsgForImageShare);
    JSONObject localJSONObject;
    Object localObject;
    if (arrayOfString != null)
    {
      if (arrayOfString.length < 8) {
        return;
      }
      paramStructMsgForImageShare = new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class);
      localJSONObject = new JSONObject();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://qc.vip.qq.com/gc/pages/detail/comicDetail.html?banSlideToTab=1&_webviewtype=4&_cwv=1&_wv=1359554403&_wwv=4&fromInternal=true&_wvx=3&id=");
      ((StringBuilder)localObject).append(arrayOfString[0]);
      localObject = ((StringBuilder)localObject).toString();
      localObject = ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).addParamToUrl((String)localObject, "from=4008001");
    }
    try
    {
      localJSONObject.put("from", "13");
      localJSONObject.put("jumpto", "com.qqcomic.activity.VipComicTabBrowserActivity");
      localJSONObject.put("url", URLEncoder.encode((String)localObject));
      localJSONObject.put("leftViewText", HardCodeUtil.a(2131700275));
      label149:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqapi://qqcomic/jump?options=");
      ((StringBuilder)localObject).append(localJSONObject.toString());
      paramStructMsgForImageShare.setData(Uri.parse(((StringBuilder)localObject).toString()));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramStructMsgForImageShare);
      if (arrayOfString.length >= 8)
      {
        if (arrayOfString[7].equals("link"))
        {
          paramStructMsgForImageShare = arrayOfString[4];
          break label255;
        }
        if ((arrayOfString[7].equals("scrawl_link")) && (arrayOfString.length >= 9))
        {
          paramStructMsgForImageShare = arrayOfString[8];
          break label255;
        }
      }
      paramStructMsgForImageShare = "";
      label255:
      if ("5".equals(paramString))
      {
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40055", arrayOfString[0], new String[] { "", "", paramStructMsgForImageShare });
        return;
      }
      if ("6".equals(paramString)) {
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", arrayOfString[0], new String[] { "3", "", paramStructMsgForImageShare });
      }
      return;
    }
    catch (Exception localException)
    {
      break label149;
    }
  }
  
  protected void c(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    String[] arrayOfString = a(paramStructMsgForImageShare);
    if (arrayOfString != null)
    {
      if (arrayOfString.length < 8) {
        return;
      }
      paramStructMsgForImageShare = new JSONObject();
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("comicID", arrayOfString[0]);
      paramString.put("comicSectionID", arrayOfString[2]);
      paramString.put("comicPageID", arrayOfString[4]);
      paramString.put("type", arrayOfString[6]);
      paramString.put("returnToHome", arrayOfString[8]);
      boolean bool = ((IQQComicConfigApi)QRoute.api(IQQComicConfigApi.class)).isEnableNewReader();
      if (bool) {
        paramStructMsgForImageShare.put("jumpto", "com.qqcomic.reader.VipComicReadingActivityV2");
      } else {
        paramStructMsgForImageShare.put("jumpto", "com.qqcomic.activity.reader.VipComicPortraitReadingActivity");
      }
      paramStructMsgForImageShare.put("comic", paramString);
      paramStructMsgForImageShare.put("from", "13");
      paramStructMsgForImageShare.put("mod", "4008002");
      i = 1;
    }
    catch (Exception paramString)
    {
      int i;
      label180:
      break label180;
    }
    i = 0;
    if (i != 0)
    {
      paramString = new ActivityURIRequest(this.jdField_a_of_type_AndroidAppActivity, "/base/vipcomic");
      paramString.extra().putString("options", paramStructMsgForImageShare.toString());
      QRoute.startUri(paramString, null);
    }
    else
    {
      paramStructMsgForImageShare = new StringBuilder();
      paramStructMsgForImageShare.append("https://cdn.vip.qq.com/club/client/comic/release/html/redirect.html?_wv=5123&_bid=354&_cfrom=13&action=read&actionType=keepread&id=");
      paramStructMsgForImageShare.append(arrayOfString[0]);
      paramStructMsgForImageShare.append("&name=");
      paramStructMsgForImageShare.append(URLEncoder.encode(arrayOfString[1]));
      paramStructMsgForImageShare.append("&sectionID=");
      paramStructMsgForImageShare.append(arrayOfString[2]);
      paramStructMsgForImageShare.append("&pageID=");
      paramStructMsgForImageShare.append(arrayOfString[4]);
      paramStructMsgForImageShare.append("&pageOffset=0&type=");
      paramStructMsgForImageShare.append(arrayOfString[6]);
      paramStructMsgForImageShare = paramStructMsgForImageShare.toString();
      paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramString.putExtra("url", paramStructMsgForImageShare);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
    }
    if (arrayOfString.length >= 8)
    {
      paramString = arrayOfString[4];
      if (arrayOfString[7].equals("link")) {
        paramStructMsgForImageShare = arrayOfString[4];
      } else if ((arrayOfString[7].equals("scrawl_link")) && (arrayOfString.length >= 9)) {
        paramStructMsgForImageShare = arrayOfString[8];
      } else {
        paramStructMsgForImageShare = "";
      }
    }
    else
    {
      paramString = "";
      paramStructMsgForImageShare = paramString;
    }
    ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40056", arrayOfString[0], new String[] { "", paramString, paramStructMsgForImageShare });
  }
  
  boolean g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if ((localObject != null) && (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
    {
      localObject = (AIOImageData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((((AIOImageData)localObject).b == 1) || (((AIOImageData)localObject).b == 2))
      {
        i = 1;
        break label55;
      }
    }
    int i = 0;
    label55:
    if (i != 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((localObject != null) && ((localObject instanceof AIOShortVideoData)) && (((AIOShortVideoData)localObject).k == 2))
      {
        localObject = this.jdField_d_of_type_AndroidWidgetButton;
        if (localObject != null) {
          ((Button)localObject).setVisibility(0);
        }
      }
    }
    this.w = true;
    return true;
  }
  
  boolean h()
  {
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    Button localButton = this.jdField_d_of_type_AndroidWidgetButton;
    if (localButton != null) {
      localButton.setVisibility(4);
    }
    return true;
  }
  
  public void h_()
  {
    super.h_();
    F();
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentWidgetDragView.init();
    this.jdField_d_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState = new AIOGalleryScene.UIState(this);
  }
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    this.jdField_d_of_type_AndroidViewView.setAlpha(paramFloat);
    if (paramFloat < 0.8F)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.e = true;
      u();
    }
  }
  
  public void onGestureFinish()
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) {
      str = "0X8009AB2";
    } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) {
      str = "0X8009AB3";
    } else {
      str = null;
    }
    if (!TextUtils.isEmpty(str)) {
      ReportController.b(null, "dc00898", "", "", str, str, this.k, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a() == null)
    {
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a() != null) {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b.thubmRect);
    } else {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b.jdField_a_of_type_AndroidGraphicsRect);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData))
    {
      this.jdField_a_of_type_ComTencentWidgetGallery.enableScaleGesture(false);
      this.jdField_a_of_type_ComTencentWidgetGallery.enableDoubleTap(false);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.enableScaleGesture(true);
    this.jdField_a_of_type_ComTencentWidgetGallery.enableDoubleTap(true);
  }
  
  public void onResetPosition()
  {
    if (this.k == 4) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.e = false;
    u();
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentWidgetDragView.mFinishAnimation)
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().i();
      return;
    }
    super.q();
  }
  
  protected void u()
  {
    super.u();
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.a) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.f))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) && (((AIOImageData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b == 5)) {
        this.g.setVisibility(0);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryScene", 2, "updateUI selectedItem all gone");
    }
    this.g.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness
 * JD-Core Version:    0.7.0.1
 */