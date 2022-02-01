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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
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
  public static int z;
  List<View> A = new ArrayList();
  List<View> B = new ArrayList();
  private boolean C = false;
  private boolean D = false;
  private int E;
  private int F;
  public int a = 0;
  public String b = "";
  public NinePatch c;
  public String d = "";
  public NinePatch e;
  public String f = "";
  public String g = "";
  public String h = "";
  public String[] i = null;
  @Deprecated
  public DiyBubbleConfig.DiyBubblePasterConfig j;
  public HashMap<String, DiyBubbleConfig> k = new HashMap(4);
  public int l;
  public int m;
  public int n;
  public boolean o;
  public boolean p;
  public double q;
  public String[] r;
  public String s;
  public int t;
  public int u;
  public BubbleInfo.CommonAttrs v;
  public BubbleInfo.CommonAttrs w;
  public List<Pair<BubbleInfo.CommonAttrs, BubbleInfo.CommonAttrs>> x;
  public HashMap<String, String> y;
  
  public BubbleInfo(int paramInt)
  {
    this.a = paramInt;
  }
  
  public BubbleInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.E = paramInt2;
    this.F = paramInt3;
  }
  
  public BubbleInfo(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, DiyBubbleConfig.DiyBubblePasterConfig paramDiyBubblePasterConfig, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, double paramDouble, String[] paramArrayOfString, BubbleInfo.CommonAttrs paramCommonAttrs1, int paramInt5, int paramInt6, BubbleInfo.CommonAttrs paramCommonAttrs2, List<Pair<BubbleInfo.CommonAttrs, BubbleInfo.CommonAttrs>> paramList, HashMap<String, String> paramHashMap)
  {
    this.a = paramInt1;
    this.g = paramString3;
    this.b = paramString1;
    this.d = paramString2;
    this.h = paramString4;
    this.j = paramDiyBubblePasterConfig;
    this.l = paramInt2;
    this.m = paramInt3;
    this.n = paramInt4;
    this.o = paramBoolean1;
    this.p = paramBoolean2;
    this.q = paramDouble;
    this.t = paramInt5;
    this.u = paramInt6;
    this.r = paramArrayOfString;
    if (paramList == null) {
      paramList = new ArrayList();
    }
    this.x = paramList;
    this.v = paramCommonAttrs1;
    this.w = paramCommonAttrs2;
    if (paramHashMap == null) {
      paramHashMap = new HashMap();
    }
    this.y = paramHashMap;
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
    paramInt1 = SkinUtils.b((Drawable)localObject) + SkinUtils.b(paramContext);
    if (paramInt1 > 0) {
      GlobalImageCache.a.put(localStringBuffer.toString(), new Pair(localStateListDrawable.getConstantState(), Integer.valueOf(paramInt1)));
    }
    return localStateListDrawable;
  }
  
  @NotNull
  private Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Object localObject1 = paramQQAppInterface.getApp().getResources();
    paramQQAppInterface = ((Resources)localObject1).getDrawable(SimpleModeHelper.a(paramBoolean, true));
    Object localObject2 = ((Resources)localObject1).getDrawable(SimpleModeHelper.a(paramBoolean, false));
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
        ((StringBuilder)localObject2).append(this.a);
        QLog.d("BubbleInfo", 2, ((StringBuilder)localObject2).toString());
      }
      GlobalImageCache.a.put(paramQQAppInterface, ((StateListDrawable)localObject1).getConstantState());
    }
    return localObject1;
  }
  
  @Nullable
  private Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable)
  {
    if ((!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.d)))
    {
      paramQQAppInterface = new VipBubbleDrawable(paramQQAppInterface.getApp().getResources(), this.c, this.e, this.a);
      paramQQAppInterface.a(paramBoolean1 ^ true, paramBoolean2);
      if (QLog.isColorLevel())
      {
        paramDrawable = new StringBuilder();
        paramDrawable.append("getBubbleDrawable, bubbleId=");
        paramDrawable.append(this.a);
        paramDrawable.append(", vipBubbleDrawable=");
        paramDrawable.append(paramQQAppInterface);
        QLog.d("BubbleInfo", 2, paramDrawable.toString());
      }
      paramDrawable = paramQQAppInterface;
      if (!BubbleManager.a)
      {
        paramDrawable = paramQQAppInterface;
        if (this.a != 0)
        {
          BubbleManager.a = true;
          return paramQQAppInterface;
        }
      }
    }
    else
    {
      int i1 = this.a;
      if ((i1 == 100000) || (i1 == 100001))
      {
        if (paramBoolean1) {
          paramQQAppInterface = null;
        } else {
          paramQQAppInterface = a(paramQQAppInterface.getApp(), this.a, paramBoolean1, paramBoolean2, this.E, this.F);
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
          paramDrawable.append(this.a);
          QLog.d("BubbleInfo", 2, paramDrawable.toString());
        }
        localDrawable = localConstantState.newDrawable();
      }
    }
    return localDrawable;
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
      return c(paramString);
    }
    return d(paramString, paramBubbleConfig);
  }
  
  private String a(BubbleConfig paramBubbleConfig)
  {
    if (paramBubbleConfig.l != null) {
      return paramBubbleConfig.l.b;
    }
    return "width";
  }
  
  private String a(String paramString, BubbleConfig paramBubbleConfig)
  {
    if (paramBubbleConfig.o != null) {
      paramString = paramBubbleConfig.o.b;
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
  
  private Pair<BubbleInfo.CommonAttrs, BubbleInfo.CommonAttrs> b(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Object localObject3 = this.x;
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
      } while (!paramString.equals(((BubbleInfo.CommonAttrs)((Pair)localObject1).first).j));
    }
    return localObject1;
  }
  
  private String b(String paramString, BubbleConfig paramBubbleConfig)
  {
    if (paramBubbleConfig.n != null) {
      paramString = paramBubbleConfig.n.b;
    }
    return paramString;
  }
  
  public static int c()
  {
    if (QQTheme.isNowSimpleUI()) {
      return 64;
    }
    return 65;
  }
  
  private String c(String paramString)
  {
    Object localObject = this.y;
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((HashMap)localObject).size() > 0)
      {
        localObject = this.s;
        str = paramString;
        if (localObject != null) {
          str = (String)this.y.get(localObject);
        }
      }
    }
    return str;
  }
  
  private String c(String paramString, BubbleConfig paramBubbleConfig)
  {
    if (paramBubbleConfig.k != null) {
      paramString = paramBubbleConfig.k.b;
    }
    return paramString;
  }
  
  private String d(String paramString, BubbleConfig paramBubbleConfig)
  {
    if (paramBubbleConfig.j != null) {
      paramString = paramBubbleConfig.j.b;
    }
    return paramString;
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBubbleDrawable, bubbleId=");
      ((StringBuilder)localObject).append(this.a);
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
    if ((bool) && (!TextUtils.isEmpty(this.h))) {
      if ((this.j != null) && (paramView != null))
      {
        int i2 = paramView.getWidth();
        if (this.j.f == 0)
        {
          ((VipBubbleDrawable)localObject).a(true, this.h, this.j.b, this.j.a);
        }
        else
        {
          int i1 = i2;
          if (i2 == 0)
          {
            paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            i1 = paramView.getMeasuredWidth();
          }
          if (i1 > this.j.f) {
            ((VipBubbleDrawable)localObject).a(true, this.h, this.j.b, this.j.a);
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
    DiyBubbleConfig.DiyBubblePasterConfig localDiyBubblePasterConfig = this.j;
    if (!paramBoolean4) {
      this.j = null;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramBoolean1, paramBoolean2, paramBoolean3, paramView, "", 0);
    this.j = localDiyBubblePasterConfig;
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
      Object localObject = paramQQAppInterface.a(this.a, true);
      if (localObject == null) {
        return null;
      }
      String str = a(paramInt, null, (BubbleConfig)localObject);
      if (!TextUtils.isEmpty(str))
      {
        localObject = b(str);
        localObject = paramQQAppInterface.a(this.a, str, (Pair)localObject);
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
    if ((this.r != null) && (!TextUtils.isEmpty(paramString)))
    {
      String[] arrayOfString = this.r;
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        if (paramString.indexOf(str.toLowerCase()) != -1)
        {
          this.s = str;
          return str;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  public void a()
  {
    synchronized (this.A)
    {
      this.A.clear();
      synchronized (this.B)
      {
        this.B.clear();
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
      int i1 = paramView.getPaddingTop();
      int i2 = localRect.top;
      int i3 = paramView.getPaddingLeft();
      int i4 = localRect.left;
      int i5 = paramView.getPaddingRight();
      int i6 = localRect.right;
      int i7 = paramView.getPaddingBottom();
      int i8 = localRect.bottom;
      paramView.setBackgroundDrawable(paramDrawable);
      paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i7 + i8);
    }
  }
  
  public void a(View arg1, View paramView2)
  {
    synchronized (this.A)
    {
      this.A.remove(???);
      synchronized (this.B)
      {
        this.B.remove(paramView2);
        return;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    int i1 = this.t;
    if (i1 > 0)
    {
      int i2 = this.u;
      if ((i2 > i1) && (paramInt >= i1) && (paramInt <= i2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b()
  {
    return (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.d));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BubbleInfo [bubbleId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",aioUserBgNorResPath=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",aioUserPicNorResPath=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",bubbleThumbnailResPath=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",bubbleChartletResPath=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mTextColor=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", mKeyWords=");
    localStringBuilder.append(Arrays.toString(this.r));
    localStringBuilder.append(", currKeyWord=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", mBubbleHeightBegin=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", mBubbleHeightEnd=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", pttAttrs=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", heightAttrs=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", keywordAttrs=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", keyWorsAnimMap=");
    localStringBuilder.append(this.y);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInfo
 * JD-Core Version:    0.7.0.1
 */