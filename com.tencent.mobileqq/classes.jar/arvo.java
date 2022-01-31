import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class arvo
  extends arvk
{
  private static ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private static FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  boolean i;
  protected boolean j;
  boolean k;
  private boolean l;
  
  public arvo(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_i_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 10;
  }
  
  private void G()
  {
    Object localObject1 = a();
    int m;
    if (localObject1 != null)
    {
      m = ((ForwardFileInfo)localObject1).b();
      if (((m == 10000) || (m == 10006)) && (f() == 2)) {
        a(f(), String.valueOf(((ForwardFileInfo)localObject1).a()));
      }
    }
    for (;;)
    {
      return;
      long l1;
      if ((m == 10000) || (m == 10001) || (m == 10002) || (m == 10004) || (m == 10003))
      {
        l1 = ((ForwardFileInfo)localObject1).b();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
        if (localObject1 != null) {
          armf.a((FileManagerEntity)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, m, 12);
        }
      }
      else if (m == 10006)
      {
        l1 = ((ForwardFileInfo)localObject1).b();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
        if (localObject2 != null)
        {
          localObject2 = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject2);
          l1 = ((ForwardFileInfo)localObject1).a();
          long l2 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("last_time", 0L);
          localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("sender_uin");
          aroo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, null, null, l1, (bbpe)localObject2, (String)localObject1, l2, -1, 12, null, false, false);
          return;
          if (bdcs.b(this.jdField_i_of_type_JavaLangString)) {
            try
            {
              localObject1 = arni.a(new FileInfo(this.jdField_i_of_type_JavaLangString));
              if (localObject1 != null)
              {
                armf.a((FileManagerEntity)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, 12);
                return;
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null) {}
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("dataline", 2, "FileManagerEntity->cloudType 转 ForwardFileInfo->type， 未识别的cloudType[" + paramFileManagerEntity.getCloudType());
      }
    case 3: 
    case 5: 
    case 6: 
    case 7: 
      do
      {
        return 10000;
      } while (arof.b(paramFileManagerEntity.getFilePath()));
      return 10009;
    case 1: 
      return 10002;
    case 2: 
      return 10003;
    }
    return 10011;
  }
  
  private Drawable a()
  {
    String str = g();
    if (bdcs.b(str))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = baul.b();
      localURLDrawableOptions.mFailedDrawable = baul.a();
      return URLDrawable.getFileDrawable(str, localURLDrawableOptions);
    }
    return null;
  }
  
  private ForwardFileInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)) {
      return (ForwardFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity)
  {
    return a(paramFileManagerEntity, null);
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    paramChatMessage = new ForwardFileInfo();
    paramChatMessage.b(a(paramFileManagerEntity));
    paramChatMessage.d(paramFileManagerEntity.getCloudType());
    paramChatMessage.b(paramFileManagerEntity.nSessionId);
    paramChatMessage.c(paramFileManagerEntity.uniseq);
    paramChatMessage.d(paramFileManagerEntity.fileName);
    paramChatMessage.d(paramFileManagerEntity.fileSize);
    paramChatMessage.a(paramFileManagerEntity.getFilePath());
    paramChatMessage.c(paramFileManagerEntity.WeiYunFileId);
    if (!TextUtils.isEmpty(paramFileManagerEntity.strLargeThumPath)) {
      paramChatMessage.f(paramFileManagerEntity.strLargeThumPath);
    }
    for (;;)
    {
      if (paramFileManagerEntity.Uuid != null) {
        paramChatMessage.b(paramFileManagerEntity.Uuid);
      }
      if (paramFileManagerEntity.TroopUin != 0L) {
        paramChatMessage.a(paramFileManagerEntity.TroopUin);
      }
      if (paramFileManagerEntity.strTroopFileID != null) {
        paramChatMessage.e(paramFileManagerEntity.strTroopFileID);
      }
      return paramChatMessage;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strMiddleThumPath)) {
        paramChatMessage.f(paramFileManagerEntity.strMiddleThumPath);
      } else {
        paramChatMessage.f(paramFileManagerEntity.strThumbPath);
      }
    }
  }
  
  private String a(String paramString)
  {
    String str = aljq.aX + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
    try
    {
      bdda.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramString, str, 600, 800);
      return str;
    }
    catch (Exception paramString) {}
    return str;
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardFileOption", 2, "startToGalleryWithPath: path=" + paramString1);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      AIOImageData localAIOImageData = new AIOImageData();
      localAIOImageData.a = paramString1;
      localAIOImageData.b = paramString1;
      localAIOImageData.c = paramString1;
      localAIOImageData.e = false;
      paramString1 = new Bundle();
      paramString1.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      paramString1.putBoolean("key_allow_forward_photo_preview_edit", true);
      a(paramString1, new AIOImageProviderService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString2, 0, null), localAIOImageData);
      D();
    }
  }
  
  private void e()
  {
    String str = f();
    if (bdcs.b(str))
    {
      File localFile = new File(str);
      this.jdField_j_of_type_JavaLangString = localFile.getName();
      this.jdField_i_of_type_JavaLangString = str;
      this.jdField_b_of_type_Long = localFile.length();
    }
  }
  
  private int f()
  {
    Object localObject = a();
    if ((localObject == null) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {}
    while ((localObject == null) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
      return -1;
    }
    if (localObject != null) {}
    String str;
    int m;
    for (localObject = ((ForwardFileInfo)localObject).d();; localObject = this.jdField_i_of_type_JavaLangString)
    {
      str = g();
      m = arni.a((String)localObject);
      if ((m != 0) || (!bdcs.b(str))) {
        break;
      }
      return 2;
    }
    if ((m == 2) && (bdcs.b(str))) {
      return 3;
    }
    return 1;
  }
  
  private String f()
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label77;
      }
      localObject2 = null;
    }
    label77:
    int m;
    do
    {
      return localObject2;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.f();
      break;
      m = arni.a((String)localObject1);
      if (m == -1) {
        break label95;
      }
      localObject2 = localObject1;
    } while (m != 11);
    label95:
    return a((String)localObject1);
  }
  
  private String g()
  {
    Object localObject = a();
    if (localObject != null) {
      localObject = ((ForwardFileInfo)localObject).f();
    }
    String str;
    do
    {
      return localObject;
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_thumb");
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return this.jdField_a_of_type_AndroidOsBundle.getString("forward_thumb");
  }
  
  protected View a()
  {
    Object localObject2 = a();
    int m = aekt.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int n = aekt.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i1 = aekt.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = aekt.a(16.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = aekt.a(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i4 = aekt.a(32.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i5 = aekt.a(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    localRelativeLayout.setOnClickListener(new arvq(this));
    localRelativeLayout.setOnTouchListener(new arvr(this));
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    int i6 = f();
    Object localObject3;
    if (i6 == 2)
    {
      localRelativeLayout.setPadding(0, i1, 0, i1);
      localObject1 = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((URLImageView)localObject1).setId(2131366760);
      ((URLImageView)localObject1).setAdjustViewBounds(true);
      ((URLImageView)localObject1).setMaxHeight(bdkf.a(140.0F));
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      ((View)localObject2).setId(2131366755);
      ((View)localObject2).setBackgroundColor(Color.argb(0, 0, 0, 0));
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131366760);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131366760);
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131366760);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131366760);
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = a();
      if (localObject2 != null) {
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
      return localRelativeLayout;
    }
    if (i6 == 3)
    {
      localRelativeLayout.setPadding(0, i1, 0, i1);
      localObject1 = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((URLImageView)localObject1).setId(2131366760);
      ((URLImageView)localObject1).setAdjustViewBounds(true);
      ((URLImageView)localObject1).setMaxHeight(bdkf.a(140.0F));
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      ((View)localObject2).setId(2131366755);
      ((View)localObject2).setBackgroundColor(Color.argb(0, 0, 0, 0));
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131366760);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131366760);
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131366760);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131366760);
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((ImageView)localObject2).setId(2131366761);
      localObject3 = new RelativeLayout.LayoutParams(i5, i5);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = a();
      if (localObject3 != null) {
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
      }
      ((ImageView)localObject2).setImageResource(2130839710);
      return localRelativeLayout;
    }
    if (i6 == 1)
    {
      localRelativeLayout.setPadding(0, i3, 0, i3);
      localObject1 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((ImageView)localObject1).setId(2131366754);
      ((ImageView)localObject1).setImageResource(2130839708);
      localObject3 = new RelativeLayout.LayoutParams(n, i2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(11);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = m;
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new AsyncImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((AsyncImageView)localObject3).setId(2131366756);
      localObject1 = new RelativeLayout.LayoutParams(i4, i4);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131366754);
      localRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      ((LinearLayout)localObject1).setId(2131366759);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setBackgroundColor(Color.argb(0, 0, 0, 0));
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(0, 2131366756);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new EllipsizingTextView(this.jdField_a_of_type_AndroidAppActivity, null);
      ((TextView)localObject4).setId(2131366757);
      ((TextView)localObject4).setMaxLines(1);
      ((TextView)localObject4).setIncludeFontPadding(false);
      ((TextView)localObject4).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject4).setTextSize(1, 14.0F);
      ((LinearLayout)localObject1).addView((View)localObject4);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      localTextView.setId(2131366758);
      localTextView.setSingleLine();
      localTextView.setGravity(3);
      localTextView.setTextColor(Color.parseColor("#777777"));
      localTextView.setTextSize(1, 14.0F);
      ((LinearLayout)localObject1).addView(localTextView);
      localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      ((LinearLayout)localObject1).setId(2131366755);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setBackgroundColor(Color.argb(0, 0, 0, 0));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(6, 2131366759);
      localLayoutParams.addRule(8, 2131366759);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      if (localObject2 != null)
      {
        localObject1 = ((ForwardFileInfo)localObject2).d();
        if (localObject2 == null) {
          break label1152;
        }
      }
      label1152:
      for (long l1 = ((ForwardFileInfo)localObject2).d();; l1 = this.jdField_b_of_type_Long)
      {
        arni.a((AsyncImageView)localObject3, (String)localObject1);
        ((TextView)localObject4).setText((CharSequence)localObject1);
        localTextView.setText(arof.a(l1, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().densityDpi));
        return localRelativeLayout;
        localObject1 = this.jdField_j_of_type_JavaLangString;
        break;
      }
    }
    localRelativeLayout.setPadding(0, i3, 0, i3);
    localObject1 = new AnimationTextView(this.jdField_a_of_type_AndroidAppActivity);
    ((AnimationTextView)localObject1).setText(a());
    ((AnimationTextView)localObject1).setMaxLines(3);
    ((AnimationTextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((AnimationTextView)localObject1).setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165649));
    ((AnimationTextView)localObject1).setTextSize(14.0F);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = azgq.a(10.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.setOnClickListener(null);
    localRelativeLayout.setOnTouchListener(null);
    return localRelativeLayout;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_source_uin_type", 0) == 9501) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 1006) || (a(aruc.h))) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 7000)) {
        if (this.jdField_j_of_type_Boolean)
        {
          if (((localRecentUser.getType() == 1) && (!a(localRecentUser.uin))) || ((localRecentUser.getType() == 0) && (!ndv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) || (localRecentUser.getType() == 3000) || (-1L != arni.a(localRecentUser.getType()))) {
            localArrayList.add(localRecentUser);
          } else if ((localRecentUser.uin.equalsIgnoreCase(aljq.z)) && (a(aruc.jdField_f_of_type_JavaLangInteger)) && (p())) {
            localArrayList.add(localRecentUser);
          }
        }
        else if (this.l)
        {
          if (((localRecentUser.getType() == 0) && (!ndv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) || (localRecentUser.getType() == 1) || (localRecentUser.getType() == 3000) || (localRecentUser.getType() == 1006) || (localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) {
            localArrayList.add(localRecentUser);
          } else if ((localRecentUser.uin.equalsIgnoreCase(aljq.z)) && (a(aruc.jdField_f_of_type_JavaLangInteger)) && (p())) {
            localArrayList.add(localRecentUser);
          }
        }
        else if (this.jdField_k_of_type_Boolean)
        {
          if (localRecentUser.getType() == 1) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser != null) && (!bdal.a(localRecentUser.uin)))
        {
          if (((localRecentUser.getType() == 0) && (!ndv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) || (localRecentUser.getType() == 3000) || ((localRecentUser.getType() == 1) && (a(c)) && (!a(localRecentUser.uin))) || (-1L != arni.a(localRecentUser.getType()))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.uin.equalsIgnoreCase(aljq.z)) && (a(aruc.jdField_f_of_type_JavaLangInteger)) && (p())) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if ((!this.jdField_k_of_type_Boolean) && (m()))
    {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(jdField_i_of_type_JavaLangInteger);
    }
    if ((!this.jdField_k_of_type_Boolean) && (k())) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10006) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10003) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10002) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10009)) || (l())) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) {
      if (allz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b())))
      {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
        this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
        break label339;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromFavorites", false))) {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
      }
      if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (o()))
      {
        int m = arni.a(f());
        if ((m == 2) || (m == 3) || (m == 0) || (m == 7) || (m == 6) || (m == 10) || (m == 9)) {
          this.jdField_a_of_type_JavaUtilSet.add(jdField_j_of_type_JavaLangInteger);
        }
      }
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        label339:
        if (!localIterator.hasNext()) {
          continue;
        }
        ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)localIterator.next();
        if ((localForwardFileInfo == null) || (!allz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localForwardFileInfo.b())))) {
          break;
        }
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
        this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
        continue;
      }
      this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 19001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      Object localObject = f();
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardFileOption", 2, "refresh forward preview,editPicPath:" + paramIntent + " :currentFile" + (String)localObject);
      }
      if (!((String)localObject).equals(paramIntent))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsBundle.remove("FORWARD_MSG_FOR_PIC");
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", paramIntent);
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_extra", paramIntent);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("extra_is_edited_pic", true);
        localObject = a();
        if (localObject != null)
        {
          ((ForwardFileInfo)localObject).a(paramIntent);
          ((ForwardFileInfo)localObject).f(paramIntent);
        }
        paramIntent = a();
        if (paramIntent != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramIntent);
        }
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_j_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (-1L != arni.a(paramBundle.getInt("uintype"))))
    {
      bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131698093), this.jdField_a_of_type_AndroidAppActivity.getString(2131698047), null, this.jdField_a_of_type_AndroidAppActivity.getString(2131720960), new arvp(this), null).show();
      return;
    }
    super.a(paramInt, paramBundle);
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array");
    if (localArrayList1 != null) {}
    for (;;)
    {
      try
      {
        localArrayList1 = (ArrayList)localArrayList1;
        ArrayList localArrayList3 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
        if (localArrayList1 == null)
        {
          localArrayList2 = new ArrayList();
          int m = 0;
          if (m < localArrayList3.size())
          {
            Uri localUri = (Uri)localArrayList3.get(m);
            localArrayList2.add(a(this.jdField_a_of_type_AndroidAppActivity, localUri));
            m += 1;
            continue;
          }
        }
      }
      catch (ClassCastException localClassCastException)
      {
        localObject = null;
        continue;
        paramIntent.putExtra("dataline_forward_type", 100);
        paramIntent.putExtra("sendMultiple", true);
        if (localObject == null) {
          paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList2);
        }
        return;
      }
      Object localObject = null;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    super.a();
    this.e = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward _key_nojump", false);
    Object localObject;
    int m;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
    {
      int n = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d();
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        m = 1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10006) {
          break label187;
        }
        bool1 = true;
        label72:
        this.jdField_j_of_type_Boolean = bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10009) {
          break label192;
        }
        bool1 = true;
        label92:
        this.jdField_k_of_type_Boolean = bool1;
        if (n != 2) {
          break label197;
        }
        bool1 = true;
        label104:
        this.l = bool1;
        bool1 = bool2;
        if (m != 0) {
          if (n != 3)
          {
            bool1 = bool2;
            if (!bdcs.a((String)localObject)) {}
          }
          else
          {
            bool1 = true;
          }
        }
        this.jdField_i_of_type_Boolean = bool1;
        label138:
        break label223;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131720570));
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) && (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
        e();
      }
      return true;
      m = 0;
      break;
      label187:
      bool1 = false;
      break label72;
      label192:
      bool1 = false;
      break label92;
      label197:
      bool1 = false;
      break label104;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_k_of_type_Boolean = true;
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        label223:
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)((Iterator)localObject).next();
        if ((localForwardFileInfo == null) || (localForwardFileInfo.d() == 6)) {
          break label138;
        }
        this.jdField_k_of_type_Boolean = false;
        continue;
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false)) {
        this.jdField_i_of_type_Boolean = true;
      }
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    zpa localzpa = (zpa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    int n = paramArrayOfDeviceInfo.length;
    int m = 0;
    if (m < n)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[m];
      ProductInfo localProductInfo;
      if (localDeviceInfo != null)
      {
        int i1 = arni.a(f());
        localProductInfo = localzpa.a(localDeviceInfo.productId);
        if ((i1 != 2) || (!localzpa.c(localDeviceInfo.din)) || (!localzpa.a(localDeviceInfo.din, 17))) {
          break label105;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        label105:
        if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(8)) && (a(jdField_j_of_type_JavaLangInteger))) {
          localArrayList.add(localDeviceInfo);
        }
      }
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 100);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
    {
      String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      String str1 = str2;
      if (str2 == null) {
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      }
      paramIntent.putExtra("dataline_forward_path", str1);
      return;
    }
    paramIntent.putExtra("dataline_forward_path", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected boolean c()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
    Intent localIntent;
    if (f())
    {
      localObject = b();
      localIntent = aekt.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "fileoption realForwardTo isfromshare=" + bool);
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", alpo.a(2131705132));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (this.jdField_f_of_type_Boolean)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
          if ((QSecFramework.a().a(1003).booleanValue()) && (this.jdField_i_of_type_Boolean))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
              bewm.a().a(4, f(), localResultRecord.a(), localResultRecord.a);
              bewm.a().a();
            }
          }
        }
        else if (!bool)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
      for (;;)
      {
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
        return false;
        if (!this.e)
        {
          localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
    }
    int m = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if (m == 1008)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", nrc.a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "fileoption realForwardTo isfromshare=" + bool);
      }
      if (!bool) {
        break label592;
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", alpo.a(2131705131));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      bool = a(localIntent);
      if (!this.jdField_f_of_type_Boolean) {
        break label567;
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      if ((QSecFramework.a().a(1003).booleanValue()) && (this.jdField_i_of_type_Boolean))
      {
        bewm.a().a(4, f(), m, (String)localObject);
        bewm.a().a();
      }
    }
    for (;;)
    {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return false;
      localIntent = aekt.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      break;
      label567:
      if (!bool)
      {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        continue;
        label592:
        if (!this.e)
        {
          localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
    }
  }
  
  protected int d()
  {
    int m;
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if (!new biqt(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, jdField_a_of_type_ComTencentMobileqqDataChatMessage, true)) {
        break label131;
      }
      jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      m = 0;
    }
    for (;;)
    {
      if (m == 0) {
        birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return m;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
      {
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b());
        if ((localFileManagerEntity != null) && (new biqt(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null, true)))
        {
          jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
          m = 0;
          continue;
        }
      }
      label131:
      m = -1;
    }
  }
  
  protected String e()
  {
    return this.jdField_a_of_type_AndroidContentContext.getString(2131720024);
  }
  
  protected boolean h()
  {
    return true;
  }
  
  protected void y()
  {
    String str1 = f();
    String str2;
    int m;
    Object localObject;
    if (!TextUtils.isEmpty(str1))
    {
      str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      m = arni.a(str1);
      if (m != 2) {
        break label92;
      }
      localObject = ztk.b;
    }
    for (;;)
    {
      ztk localztk = (ztk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str1);
      localztk.a().a((String)localObject, str2, localArrayList, null);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      label92:
      localObject = (zpa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      if ((localObject != null) && (((zpa)localObject).a(Long.parseLong(this.jdField_a_of_type_AndroidOsBundle.getString("uin")), 17)))
      {
        ((zpa)localObject).a(Long.parseLong(str2), "", "", "", 0, null);
        if (m == 0)
        {
          super.a(str1, str2, "pic");
          return;
        }
        super.a(str1, str2, "file");
        return;
      }
      if (m == 0) {
        localObject = ztk.d;
      } else {
        localObject = ztk.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvo
 * JD-Core Version:    0.7.0.1
 */