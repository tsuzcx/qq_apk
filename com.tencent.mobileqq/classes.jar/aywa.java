import QQService.PrivilegeInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aywa
  extends ayrs
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aywb(this);
  private ayvw jdField_a_of_type_Ayvw = new ayvw();
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 500;
  
  public aywa(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  private int a(List<PrivilegeInfo> paramList, LinearLayout paramLinearLayout, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, Drawable paramDrawable, boolean paramBoolean)
  {
    int k = 0;
    int i = 0;
    if (k < paramList.size())
    {
      PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)paramList.get(k);
      int j = i;
      if (!TextUtils.isEmpty(localPrivilegeInfo.strDeluxeIconUrl))
      {
        if (i == 0) {}
        for (j = 0;; j = paramInt1)
        {
          i += 1;
          paramArrayOfInt[0] = (paramArrayOfInt[0] - paramInt2 - j);
          if (paramArrayOfInt[0] >= 0) {
            break;
          }
          paramInt1 = i;
          if (QLog.isColorLevel())
          {
            QLog.d("ProfileDiamondWallComponent", 1, "medal list layout is big =" + localPrivilegeInfo.iIsBig + " icon index=" + i);
            paramInt1 = i;
          }
          return paramInt1;
        }
        a(localPrivilegeInfo, localPrivilegeInfo.strDeluxeIconUrl, paramLinearLayout, paramInt2, paramInt3, j, paramDrawable, paramBoolean);
        j = i;
      }
      if (!TextUtils.isEmpty(localPrivilegeInfo.strIconUrl))
      {
        if (j == 0) {}
        for (i = 0;; i = paramInt1)
        {
          j += 1;
          paramArrayOfInt[0] = (paramArrayOfInt[0] - paramInt2 - i);
          if (paramArrayOfInt[0] >= 0) {
            break label268;
          }
          paramInt1 = j;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ProfileDiamondWallComponent", 1, "medal list layout is big =" + localPrivilegeInfo.iIsBig + " icon index=" + j);
          return j;
        }
        label268:
        a(localPrivilegeInfo, localPrivilegeInfo.strIconUrl, paramLinearLayout, paramInt2, paramInt3, i, paramDrawable, paramBoolean);
      }
      for (i = j;; i = j)
      {
        k += 1;
        break;
      }
    }
    return i;
  }
  
  private View a(PrivilegeInfo paramPrivilegeInfo, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, Drawable paramDrawable)
  {
    int i = aneg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("generateMedalLinerLayout , info.strTipsIconUrl: %s info.iRemindTime: %s info.iTipsTimes: %s info.iIsRemind: %s", new Object[] { paramPrivilegeInfo.strTipsIconUrl, Integer.valueOf(paramPrivilegeInfo.iRemindTime), Integer.valueOf(paramPrivilegeInfo.iTipsTimes), Integer.valueOf(paramPrivilegeInfo.iIsRemind) }));
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    Object localObject = paramPrivilegeInfo.strTipsIconUrl;
    if ((paramPrivilegeInfo.iIsRemind != 0) && (a(paramPrivilegeInfo.iRemindTime, paramPrivilegeInfo.iType)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      localLinearLayout.addView(b(paramPrivilegeInfo, (String)localObject, paramFloat1, paramFloat2 / 2.0F, paramFloat3, paramDrawable));
      localLayoutParams.topMargin = ((int)-(paramFloat2 / 2.0F));
      if (paramPrivilegeInfo.iType == 1) {
        a("0X800B27B", i);
      }
    }
    paramString = b(paramPrivilegeInfo, paramString, paramFloat1, paramFloat2, paramFloat3, paramDrawable);
    if (paramPrivilegeInfo.iIsRemind != 0)
    {
      this.jdField_a_of_type_Ayvw.removeMessages(paramPrivilegeInfo.iType);
      paramDrawable = Message.obtain();
      paramDrawable.what = paramPrivilegeInfo.iType;
      paramDrawable.obj = paramString;
      paramDrawable.arg1 = 1;
      localObject = new Bundle();
      ((Bundle)localObject).putLong("iRemindTime", paramPrivilegeInfo.iRemindTime);
      ((Bundle)localObject).putInt("iTipsTimes", paramPrivilegeInfo.iTipsTimes);
      paramDrawable.setData((Bundle)localObject);
      this.jdField_a_of_type_Ayvw.sendMessageDelayed(paramDrawable, 500L);
      if (paramPrivilegeInfo.iType == 1) {
        a("0X800B27D", i);
      }
    }
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(paramString);
    return localLinearLayout;
  }
  
  public static void a(long paramLong, int paramInt)
  {
    BaseApplication.getContext().getSharedPreferences("sp_icon_twinkle", 0).edit().putLong("sp_show_pop_begin_time" + paramInt, paramLong).apply();
  }
  
  private void a(PrivilegeInfo paramPrivilegeInfo, String paramString, LinearLayout paramLinearLayout, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, boolean paramBoolean)
  {
    paramString = a(paramPrivilegeInfo, paramString, paramInt1, paramInt2, paramInt3, paramDrawable);
    paramLinearLayout.addView(paramString);
    if (!TextUtils.isEmpty(paramPrivilegeInfo.strJumpUrl))
    {
      paramString.setClickable(true);
      paramString.setTag(new aykg(93, paramPrivilegeInfo));
      paramString.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramLinearLayout = new StringBuilder();
      a(paramLinearLayout, paramPrivilegeInfo);
      paramLinearLayout.append("徽章");
      paramString.setContentDescription(paramLinearLayout);
      paramString = "";
      switch (paramPrivilegeInfo.iType)
      {
      default: 
        if ((this.jdField_a_of_type_Int & 0x8) == 0)
        {
          if (paramBoolean)
          {
            paramString = "0X800A136";
            label147:
            this.jdField_a_of_type_Int |= 0x8;
          }
        }
        else {
          label158:
          if (!TextUtils.isEmpty(paramString))
          {
            if (paramPrivilegeInfo.iIsBig != 1) {
              break label405;
            }
            if (!paramPrivilegeInfo.isOpen) {
              break label399;
            }
            paramInt1 = 1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramLinearLayout = "";
      if (paramPrivilegeInfo.iType != 1)
      {
        paramPrivilegeInfo = paramLinearLayout;
        if (!paramString.equals("0X800A136")) {}
      }
      else
      {
        paramPrivilegeInfo = String.valueOf(aneg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false));
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", paramString, paramInt1, 0, paramPrivilegeInfo, "", "", "");
      return;
      paramString.setTag(null);
      paramString.setOnClickListener(null);
      paramString.setClickable(false);
      break;
      if ((this.jdField_a_of_type_Int & 0x1) != 0) {
        break label158;
      }
      if (paramBoolean) {}
      for (paramString = "0X800A132";; paramString = "0X800A12A")
      {
        this.jdField_a_of_type_Int |= 0x1;
        break;
      }
      if ((this.jdField_a_of_type_Int & 0x2) != 0) {
        break label158;
      }
      if (paramBoolean) {}
      for (paramString = "0X800A134";; paramString = "0X800A12C")
      {
        this.jdField_a_of_type_Int |= 0x2;
        break;
      }
      if ((this.jdField_a_of_type_Int & 0x4) != 0) {
        break label158;
      }
      if (paramBoolean) {}
      for (paramString = "0X800A130";; paramString = "0X800A128")
      {
        this.jdField_a_of_type_Int |= 0x4;
        break;
      }
      paramString = "0X800A12E";
      break label147;
      label399:
      paramInt1 = 2;
      continue;
      label405:
      if (paramPrivilegeInfo.isOpen) {
        paramInt1 = 3;
      } else {
        paramInt1 = 4;
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString, paramString, paramInt, 0, String.valueOf(paramInt), "", "", "");
  }
  
  private void a(StringBuilder paramStringBuilder, PrivilegeInfo paramPrivilegeInfo)
  {
    if (paramPrivilegeInfo == null) {
      return;
    }
    switch (paramPrivilegeInfo.iType)
    {
    default: 
      return;
    case 1: 
      paramStringBuilder.append("会员");
      return;
    case 2: 
      paramStringBuilder.append("超级QQ");
      return;
    case 4: 
      paramStringBuilder.append("好莱坞会员");
      return;
    case 3: 
      paramStringBuilder.append("超级会员");
      return;
    case 5: 
      paramStringBuilder.append("腾讯图书VIP");
      return;
    case 104: 
      paramStringBuilder.append("情侣黄钻");
      return;
    case 103: 
      paramStringBuilder.append("绿钻");
      return;
    case 101: 
      paramStringBuilder.append("红钻");
      return;
    case 105: 
      paramStringBuilder.append("超级星钻");
      return;
    case 102: 
      paramStringBuilder.append("黄钻");
      return;
    }
    paramStringBuilder.append("大会员");
  }
  
  private void a(StringBuilder paramStringBuilder, List<PrivilegeInfo> paramList)
  {
    if ((paramStringBuilder == null) || (paramList == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        a(paramStringBuilder, (PrivilegeInfo)paramList.get(i));
        i += 1;
      }
    }
  }
  
  private void a(List<PrivilegeInfo> paramList, LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    float f1 = 20.0F * this.jdField_a_of_type_Float;
    float f2 = 20.0F * this.jdField_a_of_type_Float;
    float f3 = 2.0F * this.jdField_a_of_type_Float;
    float f4 = this.jdField_a_of_type_Float;
    f4 = 5.0F * this.jdField_a_of_type_Float;
    float f5 = 6.0F * this.jdField_a_of_type_Float;
    float f6 = 8.0F * this.jdField_a_of_type_Float;
    float f7 = this.jdField_a_of_type_Float;
    f7 = this.jdField_a_of_type_Float;
    float f8 = 36.0F * this.jdField_a_of_type_Float;
    if ((paramLinearLayout == null) || (paramList == null) || (paramList.size() < 1)) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i;
    Object localObject;
    int j;
    label162:
    label192:
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    int[] arrayOfInt;
    int k;
    label385:
    do
    {
      return;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      i = 0;
      if (i < paramList.size())
      {
        localObject = (PrivilegeInfo)paramList.get(i);
        if (((PrivilegeInfo)localObject).iIsBig == 1)
        {
          j = 1;
          if (j == 0) {
            break label192;
          }
          localArrayList1.add(localObject);
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label162;
          localArrayList2.add(localObject);
        }
      }
      paramList = new ColorDrawable(16777215);
      localObject = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout)localObject).setOrientation(0);
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams1);
      localLinearLayout.setOrientation(0);
      localLinearLayout.setLayoutParams(localLayoutParams2);
      arrayOfInt = new int[1];
      if (QzoneConfig.getInstance().getConfig("qqsetting", "usersummarycardmedalicon", 0) != 0) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label500;
      }
      arrayOfInt[0] = ((int)(this.jdField_b_of_type_Float - f3));
      k = a(localArrayList1, localLinearLayout, (int)f3, arrayOfInt, (int)f8, (int)f8, paramList, paramBoolean);
      if (k > 0) {
        arrayOfInt[0] -= (int)f5;
      }
      if (k <= 0) {
        break label492;
      }
      j = (int)f6;
      j = a(localArrayList2, (LinearLayout)localObject, j, arrayOfInt, (int)f1, (int)f2, paramList, paramBoolean);
      paramLinearLayout.setOrientation(0);
      if (k > 0) {
        paramLinearLayout.addView(localLinearLayout);
      }
    } while (j <= 0);
    if (k > 0)
    {
      if (i != 0) {
        localLayoutParams1.leftMargin = ((int)f5);
      }
    }
    else
    {
      label446:
      if (i == 0) {
        break label611;
      }
      localLayoutParams2.gravity = 16;
      localLayoutParams1.gravity = 16;
    }
    for (;;)
    {
      localLinearLayout.setLayoutParams(localLayoutParams2);
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams1);
      paramLinearLayout.addView((View)localObject);
      return;
      i = 0;
      break;
      label492:
      j = (int)f4;
      break label385;
      label500:
      arrayOfInt[0] = ((int)(this.jdField_b_of_type_Float - f3));
      k = a(localArrayList1, localLinearLayout, 0, arrayOfInt, (int)f8, (int)f8, paramList, paramBoolean);
      arrayOfInt[0] = ((int)(this.jdField_b_of_type_Float - f6 - f3));
      if (k > 0) {}
      for (j = (int)(16.0F * f7);; j = (int)f4)
      {
        j = a(localArrayList2, (LinearLayout)localObject, j, arrayOfInt, (int)f1, (int)f2, paramList, paramBoolean);
        paramLinearLayout.setOrientation(1);
        break;
      }
      localLayoutParams1.leftMargin = ((int)f6);
      break label446;
      label611:
      localLayoutParams1.topMargin = ((int)f3);
    }
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    boolean bool = false;
    if (paramLong != BaseApplication.getContext().getSharedPreferences("sp_icon_twinkle", 0).getLong("sp_show_pop_begin_time" + paramInt, 0L)) {
      bool = true;
    }
    return bool;
  }
  
  private View b(PrivilegeInfo paramPrivilegeInfo, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, Drawable paramDrawable)
  {
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    Object localObject = new LinearLayout.LayoutParams((int)paramFloat1, (int)paramFloat2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)paramFloat3);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    localURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramDrawable = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, paramDrawable);
    if (paramDrawable != null)
    {
      ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), localURLImageView);
      if (paramDrawable.getStatus() == 2)
      {
        localURLImageView.setVisibility(8);
        paramDrawable.restartDownload();
      }
      if ((!TextUtils.isEmpty(paramPrivilegeInfo.strTipsIconUrl)) && ((paramDrawable.getCurrDrawable() instanceof ApngDrawable)))
      {
        localObject = ((ApngDrawable)paramDrawable.getCurrDrawable()).getImage();
        ((ApngImage)localObject).apngLoop = paramPrivilegeInfo.iTipsTimes;
        ((ApngImage)localObject).setDensity(500);
      }
      localURLImageView.setImageDrawable(paramDrawable);
      localURLImageView.setURLDrawableDownListener(new bhhf(localURLImageView, paramString, "showDiamondImage onLoadFailed iconUrl = "));
      return localURLImageView;
    }
    QLog.e("QVipSettingMe.ProfileDiamondWallComponent", 1, "apn drawable get null!iconUrl:" + paramString);
    return localURLImageView;
  }
  
  public int a()
  {
    return 1019;
  }
  
  public String a()
  {
    return "ProfileDiamondWallComponent";
  }
  
  public void a(aymg paramaymg, View paramView)
  {
    if ((paramaymg == null) || (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramView == null)) {
      return;
    }
    paramView.setVisibility(0);
    Object localObject3 = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard;
    Object localObject1 = ((Card)localObject3).getPrivilegeOpenInfo();
    Object localObject2 = ((Card)localObject3).getPrivilegeCloseInfo();
    TextView localTextView = (TextView)paramView.findViewById(2131373050);
    paramView = (LinearLayout)paramView.findViewById(2131365595);
    paramView.removeAllViews();
    StringBuilder localStringBuilder = new StringBuilder(24);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693068));
    if ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      paramaymg = new ArrayList();
      localObject3 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      if ((localObject1 != null) && ((((List)localObject1).size() > 0) || ((localObject2 != null) && (!((List)localObject2).isEmpty()))))
      {
        paramView.setVisibility(0);
        localTextView.setVisibility(8);
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)localIterator.next();
          if (localPrivilegeInfo.iIsBig == 1) {
            ((List)localObject3).add(localPrivilegeInfo);
          }
          for (;;)
          {
            localPrivilegeInfo.isOpen = true;
            break;
            localArrayList.add(localPrivilegeInfo);
          }
        }
        localStringBuilder.append("你已开通");
        a(localStringBuilder, (List)localObject1);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          break label404;
        }
        localObject1 = ((List)localObject2).iterator();
        label304:
        if (!((Iterator)localObject1).hasNext()) {
          break label404;
        }
        localObject2 = (PrivilegeInfo)((Iterator)localObject1).next();
        if (((PrivilegeInfo)localObject2).iIsBig != 1) {
          break label391;
        }
        ((List)localObject3).add(localObject2);
      }
      for (;;)
      {
        ((PrivilegeInfo)localObject2).isOpen = false;
        break label304;
        paramView.setVisibility(8);
        localTextView.setVisibility(0);
        localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698451));
        localStringBuilder.append("你未开通特权服务，快去开通vip服务吧！");
        break;
        label391:
        localArrayList.add(localObject2);
      }
      label404:
      paramaymg.addAll((Collection)localObject3);
      paramaymg.addAll(localArrayList);
      a(paramaymg, paramView, false);
    }
    for (;;)
    {
      paramView.setContentDescription(localStringBuilder);
      a(localTextView, null, null);
      return;
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break;
      }
      paramView.setVisibility(0);
      localTextView.setVisibility(8);
      a((List)localObject1, paramView, true);
      localStringBuilder.append("你的好友已开通");
      a(localStringBuilder, (List)localObject1);
    }
    paramaymg = ((Card)localObject3).privilegePromptStr;
    if (TextUtils.isEmpty(paramaymg)) {
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698450));
    }
    for (;;)
    {
      localStringBuilder.append("TA还未开通任何服务特权");
      paramView.setVisibility(8);
      localTextView.setVisibility(0);
      break;
      localTextView.setText(paramaymg);
    }
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    paramBundle = paramBaseActivity.getDisplayMetrics();
    this.jdField_a_of_type_Float = paramBundle.density;
    float f1 = Math.min(paramBundle.widthPixels, paramBundle.heightPixels);
    float f2 = paramBaseActivity.getDimensionPixelSize(2131297231) + paramBaseActivity.getDimensionPixelSize(2131297538) + paramBaseActivity.getDimensionPixelSize(2131297539);
    float f3 = this.jdField_a_of_type_Float;
    int i = paramBaseActivity.getDimensionPixelSize(2131297535);
    int j = paramBaseActivity.getDimensionPixelSize(2131297536);
    float f4 = i;
    this.jdField_b_of_type_Float = (f1 - f2 - (j + (7.0F * f3 + f4)));
  }
  
  public boolean a(aymg paramaymg)
  {
    boolean bool = super.a(paramaymg);
    return a((aymg)this.jdField_b_of_type_JavaLangObject, ((aymg)this.jdField_b_of_type_JavaLangObject).d) | bool;
  }
  
  public boolean a(aymg paramaymg, boolean paramBoolean)
  {
    paramBoolean = true;
    boolean bool = true;
    Object localObject;
    if (paramaymg == null)
    {
      localObject = null;
      if (localObject != null) {
        break label46;
      }
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label41;
      }
    }
    label41:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.jdField_a_of_type_JavaLangObject = null;
      return paramBoolean;
      localObject = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard;
      break;
    }
    label46:
    if (!bftf.b(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeAccountLineThree, , diamond: %s", new Object[] { Boolean.valueOf(bool) }));
      }
      if (bool) {
        break label118;
      }
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label113;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangObject = null;
      return paramBoolean;
      bool = false;
      break;
      label113:
      paramBoolean = false;
    }
    label118:
    if (0 == 0)
    {
      localObject = this.jdField_a_of_type_Ayyp.a("map_key_diamond");
      if (localObject != null) {
        paramBoolean = true;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        localObject = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561332, null);
        paramBoolean = true;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaLangObject = localObject;
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131362968);
        View localView = ((View)localObject).findViewById(2131365594);
        if (bool)
        {
          a(paramaymg, localView);
          paramaymg = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
          paramaymg.leftMargin = 0;
          localView.setLayoutParams(paramaymg);
        }
        for (;;)
        {
          if (bool)
          {
            ((View)localObject).setTag(new aykg(26, null));
            ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          a(null, null, localImageView);
          return paramBoolean;
          localView.setVisibility(8);
          ((View)localObject).setTag(null);
        }
      }
      paramBoolean = false;
      continue;
      localObject = null;
      paramBoolean = false;
    }
  }
  
  public String a_()
  {
    return "map_key_diamond";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywa
 * JD-Core Version:    0.7.0.1
 */