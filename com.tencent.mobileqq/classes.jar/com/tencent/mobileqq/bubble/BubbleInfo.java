package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BubbleInfo
{
  public static int g;
  public double a;
  public int a;
  public NinePatch a;
  public BubbleInfo.CommonAttrs a;
  @Deprecated
  public DiyBubbleConfig.DiyBubblePasterConfig a;
  public String a;
  public HashMap<String, DiyBubbleConfig> a;
  public List<Pair<BubbleInfo.CommonAttrs, BubbleInfo.CommonAttrs>> a;
  public boolean a;
  public String[] a;
  public int b;
  public NinePatch b;
  public BubbleInfo.CommonAttrs b;
  public String b;
  public HashMap<String, String> b;
  List<View> b;
  public boolean b;
  public String[] b;
  public int c;
  public String c;
  List<View> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  public int d;
  public String d;
  private boolean d;
  public int e;
  public String e;
  public int f;
  public String f;
  private int h;
  private int i;
  
  public BubbleInfo(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public BubbleInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
  }
  
  public BubbleInfo(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, DiyBubbleConfig.DiyBubblePasterConfig paramDiyBubblePasterConfig, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, double paramDouble, String[] paramArrayOfString, BubbleInfo.CommonAttrs paramCommonAttrs1, int paramInt5, int paramInt6, BubbleInfo.CommonAttrs paramCommonAttrs2, List<Pair<BubbleInfo.CommonAttrs, BubbleInfo.CommonAttrs>> paramList, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig = paramDiyBubblePasterConfig;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_e_of_type_Int = paramInt5;
    this.jdField_f_of_type_Int = paramInt6;
    this.jdField_b_of_type_ArrayOfJavaLangString = paramArrayOfString;
    if (paramList == null) {
      paramList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = paramCommonAttrs1;
    this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = paramCommonAttrs2;
    if (paramHashMap == null) {
      paramHashMap = new HashMap();
    }
    this.jdField_b_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  private Drawable a(Context paramContext, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("bubbleinfo_");
    localStringBuffer.append(paramInt1);
    localStringBuffer.append("_bg_");
    localStringBuffer.append(paramBoolean1);
    localStringBuffer.append("_");
    localStringBuffer.append(paramBoolean2);
    Object localObject = (Pair)GlobalImageCache.a.get(localStringBuffer.toString());
    if ((localObject != null) && (((Pair)localObject).first != null)) {
      return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramContext.getResources());
    }
    localObject = paramContext.getResources().getDrawable(paramInt2);
    paramContext = paramContext.getResources().getDrawable(paramInt3);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    if (localObject != null) {
      localStateListDrawable.addState(new int[] { 16842919, 16842910 }, (Drawable)localObject);
    }
    if (paramContext != null)
    {
      localStateListDrawable.addState(new int[] { 16842910 }, paramContext);
      localStateListDrawable.addState(new int[] { -16842910 }, paramContext);
    }
    paramInt1 = SkinUtils.a((Drawable)localObject) + SkinUtils.a(paramContext);
    if (paramInt1 > 0) {
      GlobalImageCache.a.put(localStringBuffer.toString(), new Pair(localStateListDrawable.getConstantState(), Integer.valueOf(paramInt1)));
    }
    return localStateListDrawable;
  }
  
  @NotNull
  private Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Object localObject1 = paramQQAppInterface.getApp().getResources();
    int j;
    if (paramBoolean) {
      j = 2130850336;
    } else {
      j = 2130850160;
    }
    paramQQAppInterface = ((Resources)localObject1).getDrawable(j);
    if (paramBoolean) {
      j = 2130850335;
    } else {
      j = 2130850159;
    }
    Object localObject2 = ((Resources)localObject1).getDrawable(j);
    localObject1 = new StateListDrawable();
    ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, paramQQAppInterface);
    ((StateListDrawable)localObject1).addState(new int[] { 16842910 }, (Drawable)localObject2);
    if (GlobalImageCache.a != null)
    {
      if (paramBoolean) {
        paramQQAppInterface = "bubblebg://default_mine";
      } else {
        paramQQAppInterface = "bubblebg://default_friend";
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getBubbleDrawable, put default bubble to imageCache, key=");
        ((StringBuilder)localObject2).append(paramQQAppInterface);
        ((StringBuilder)localObject2).append(", bubbleId=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        QLog.d("BubbleInfo", 2, ((StringBuilder)localObject2).toString());
      }
      GlobalImageCache.a.put(paramQQAppInterface, ((StateListDrawable)localObject1).getConstantState());
    }
    return localObject1;
  }
  
  @Nullable
  private Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      paramQQAppInterface = new VipBubbleDrawable(paramQQAppInterface.getApp().getResources(), this.jdField_a_of_type_AndroidGraphicsNinePatch, this.jdField_b_of_type_AndroidGraphicsNinePatch, this.jdField_a_of_type_Int);
      paramQQAppInterface.a(paramBoolean1 ^ true, paramBoolean2);
      if (QLog.isColorLevel())
      {
        paramDrawable = new StringBuilder();
        paramDrawable.append("getBubbleDrawable, bubbleId=");
        paramDrawable.append(this.jdField_a_of_type_Int);
        paramDrawable.append(", vipBubbleDrawable=");
        paramDrawable.append(paramQQAppInterface);
        QLog.d("BubbleInfo", 2, paramDrawable.toString());
      }
      paramDrawable = paramQQAppInterface;
      if (!BubbleManager.jdField_a_of_type_Boolean)
      {
        paramDrawable = paramQQAppInterface;
        if (this.jdField_a_of_type_Int != 0)
        {
          BubbleManager.jdField_a_of_type_Boolean = true;
          return paramQQAppInterface;
        }
      }
    }
    else
    {
      int j = this.jdField_a_of_type_Int;
      if ((j == 100000) || (j == 100001))
      {
        if (paramBoolean1) {
          paramQQAppInterface = null;
        } else {
          paramQQAppInterface = a(paramQQAppInterface.getApp(), this.jdField_a_of_type_Int, paramBoolean1, paramBoolean2, this.h, this.i);
        }
        paramDrawable = paramQQAppInterface;
      }
    }
    return paramDrawable;
  }
  
  @NotNull
  private Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramBoolean2) {
      localDrawable = a(paramQQAppInterface, paramBoolean1, paramBoolean3, paramDrawable);
    }
    paramDrawable = localDrawable;
    if (localDrawable == null) {
      paramDrawable = a(paramBoolean1, localDrawable);
    }
    localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = a(paramQQAppInterface, paramBoolean1);
    }
    return localDrawable;
  }
  
  private Drawable a(boolean paramBoolean, Drawable paramDrawable)
  {
    String str;
    if (paramBoolean) {
      str = "bubblebg://default_mine";
    } else {
      str = "bubblebg://default_friend";
    }
    Drawable localDrawable = paramDrawable;
    if (GlobalImageCache.a != null)
    {
      Drawable.ConstantState localConstantState = (Drawable.ConstantState)GlobalImageCache.a.get(str);
      localDrawable = paramDrawable;
      if (localConstantState != null)
      {
        if (QLog.isColorLevel())
        {
          paramDrawable = new StringBuilder();
          paramDrawable.append("getBubbleDrawable, get Default from imageCache, key=");
          paramDrawable.append(str);
          paramDrawable.append(", bubbleId=");
          paramDrawable.append(this.jdField_a_of_type_Int);
          QLog.d("BubbleInfo", 2, paramDrawable.toString());
        }
        localDrawable = localConstantState.newDrawable();
      }
    }
    return localDrawable;
  }
  
  private Pair<BubbleInfo.CommonAttrs, BubbleInfo.CommonAttrs> a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Object localObject3 = this.jdField_a_of_type_JavaUtilList;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (Pair)((Iterator)localObject3).next();
      } while (!paramString.equals(((BubbleInfo.CommonAttrs)((Pair)localObject1).first).jdField_b_of_type_JavaLangString));
    }
    return localObject1;
  }
  
  private String a(int paramInt, String paramString, BubbleConfig paramBubbleConfig)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 6)
            {
              if (paramInt != 7) {
                return paramString;
              }
              return a(paramString, paramBubbleConfig);
            }
            return b(paramString, paramBubbleConfig);
          }
          return a(paramBubbleConfig);
        }
        return c(paramString, paramBubbleConfig);
      }
      return b(paramString);
    }
    return d(paramString, paramBubbleConfig);
  }
  
  private String a(BubbleConfig paramBubbleConfig)
  {
    if (paramBubbleConfig.c != null) {
      return paramBubbleConfig.c.jdField_b_of_type_JavaLangString;
    }
    return "width";
  }
  
  private String a(String paramString, BubbleConfig paramBubbleConfig)
  {
    if (paramBubbleConfig.e != null) {
      paramString = paramBubbleConfig.e.jdField_b_of_type_JavaLangString;
    }
    return paramString;
  }
  
  private void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, int paramInt, Drawable paramDrawable)
  {
    if (((paramDrawable instanceof VipBubbleDrawable)) && (paramBoolean2) && (!paramBoolean3) && (paramInt > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      paramString = localStringBuilder.toString();
      ((VipBubbleDrawable)paramDrawable).a(paramQQAppInterface, paramString, paramBoolean1 ^ true);
    }
  }
  
  private String b(String paramString)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilHashMap;
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((HashMap)localObject).size() > 0)
      {
        localObject = this.jdField_f_of_type_JavaLangString;
        str = paramString;
        if (localObject != null) {
          str = (String)this.jdField_b_of_type_JavaUtilHashMap.get(localObject);
        }
      }
    }
    return str;
  }
  
  private String b(String paramString, BubbleConfig paramBubbleConfig)
  {
    if (paramBubbleConfig.d != null) {
      paramString = paramBubbleConfig.d.jdField_b_of_type_JavaLangString;
    }
    return paramString;
  }
  
  private String c(String paramString, BubbleConfig paramBubbleConfig)
  {
    if (paramBubbleConfig.b != null) {
      paramString = paramBubbleConfig.b.jdField_b_of_type_JavaLangString;
    }
    return paramString;
  }
  
  private String d(String paramString, BubbleConfig paramBubbleConfig)
  {
    if (paramBubbleConfig.a != null) {
      paramString = paramBubbleConfig.a.jdField_b_of_type_JavaLangString;
    }
    return paramString;
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBubbleDrawable, bubbleId=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", isUser=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", needVipBubble=");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(", useAnimationBg=");
      ((StringBuilder)localObject).append(paramBoolean3);
      ((StringBuilder)localObject).append(", senderUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("BubbleInfo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramQQAppInterface, paramBoolean1, paramBoolean2, paramBoolean3, null);
    boolean bool = localObject instanceof VipBubbleDrawable;
    if ((bool) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))) {
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig != null) && (paramView != null))
      {
        int k = paramView.getWidth();
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig.jdField_c_of_type_Int == 0)
        {
          ((VipBubbleDrawable)localObject).a(true, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig.jdField_a_of_type_JavaLangString);
        }
        else
        {
          int j = k;
          if (k == 0)
          {
            paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            j = paramView.getMeasuredWidth();
          }
          if (j > this.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig.jdField_c_of_type_Int) {
            ((VipBubbleDrawable)localObject).a(true, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig.jdField_a_of_type_JavaLangString);
          } else {
            ((VipBubbleDrawable)localObject).a(false, null, null, null);
          }
        }
      }
      else if (bool)
      {
        ((VipBubbleDrawable)localObject).a(false, null, null, null);
      }
    }
    a(paramQQAppInterface, paramBoolean1, paramBoolean2, paramBoolean3, paramString, paramInt, (Drawable)localObject);
    a(paramView, (Drawable)localObject);
    return localObject;
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView, boolean paramBoolean4)
  {
    DiyBubbleConfig.DiyBubblePasterConfig localDiyBubblePasterConfig = this.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig;
    if (!paramBoolean4) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig = null;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramBoolean1, paramBoolean2, paramBoolean3, paramView, "", 0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig = localDiyBubblePasterConfig;
    return paramQQAppInterface;
  }
  
  public Pair<BubbleInfo.CommonAttrs, BubbleInfo.CommonAttrs> a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface != null) {
      paramQQAppInterface = (BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    } else {
      paramQQAppInterface = null;
    }
    if (paramQQAppInterface != null)
    {
      Object localObject = paramQQAppInterface.a(this.jdField_a_of_type_Int, true);
      if (localObject == null) {
        return null;
      }
      String str = a(paramInt, null, (BubbleConfig)localObject);
      if (!TextUtils.isEmpty(str))
      {
        localObject = a(str);
        localObject = paramQQAppInterface.a(this.jdField_a_of_type_Int, str, (Pair)localObject);
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getAttrs|key=");
          localStringBuilder.append(str);
          localStringBuilder.append(", animAttrs=");
          if (localObject == null)
          {
            paramQQAppInterface = "null";
          }
          else
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("first:");
            paramQQAppInterface.append(((Pair)localObject).first);
            paramQQAppInterface.append(",second:");
            paramQQAppInterface.append(((Pair)localObject).second);
            paramQQAppInterface = paramQQAppInterface.toString();
          }
          localStringBuilder.append(paramQQAppInterface);
          QLog.w("BubbleInfo", 4, localStringBuilder.toString());
        }
        return localObject;
      }
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_b_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(paramString)))
    {
      String[] arrayOfString = this.jdField_b_of_type_ArrayOfJavaLangString;
      int k = arrayOfString.length;
      int j = 0;
      while (j < k)
      {
        String str = arrayOfString[j];
        if (paramString.indexOf(str.toLowerCase()) != -1)
        {
          this.jdField_f_of_type_JavaLangString = str;
          return str;
        }
        j += 1;
      }
    }
    return null;
  }
  
  public void a()
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        this.jdField_c_of_type_JavaUtilList.clear();
        return;
      }
    }
  }
  
  public void a(View paramView, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (paramView == null) {
        return;
      }
      Rect localRect = new Rect();
      paramDrawable.getPadding(localRect);
      int j = paramView.getPaddingTop();
      int k = localRect.top;
      int m = paramView.getPaddingLeft();
      int n = localRect.left;
      int i1 = paramView.getPaddingRight();
      int i2 = localRect.right;
      int i3 = paramView.getPaddingBottom();
      int i4 = localRect.bottom;
      paramView.setBackgroundDrawable(paramDrawable);
      paramView.setPadding(m + n, j + k, i1 + i2, i3 + i4);
    }
  }
  
  public void a(View arg1, View paramView2)
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.remove(???);
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        this.jdField_c_of_type_JavaUtilList.remove(paramView2);
        return;
      }
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean a(int paramInt)
  {
    int j = this.jdField_e_of_type_Int;
    if (j > 0)
    {
      int k = this.jdField_f_of_type_Int;
      if ((k > j) && (paramInt >= j) && (paramInt <= k)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BubbleInfo [bubbleId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",aioUserBgNorResPath=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",aioUserPicNorResPath=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",bubbleThumbnailResPath=");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(",bubbleChartletResPath=");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append(", mTextColor=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mKeyWords=");
    localStringBuilder.append(Arrays.toString(this.jdField_b_of_type_ArrayOfJavaLangString));
    localStringBuilder.append(", currKeyWord=");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append(", mBubbleHeightBegin=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", mBubbleHeightEnd=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", pttAttrs=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs);
    localStringBuilder.append(", heightAttrs=");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs);
    localStringBuilder.append(", keywordAttrs=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", keyWorsAnimMap=");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilHashMap);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInfo
 * JD-Core Version:    0.7.0.1
 */