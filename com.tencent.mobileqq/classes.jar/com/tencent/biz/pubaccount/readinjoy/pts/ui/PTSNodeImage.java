package com.tencent.biz.pubaccount.readinjoy.pts.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import bfpk;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import com.tencent.qphone.base.util.QLog;
import pay;
import pwf;
import qnv;

public class PTSNodeImage
  extends PTSNodeVirtual<PTSImageView>
{
  public static final String TAG = "PTSNodeImage";
  private float blurRadius = 0.0F;
  private String imageUrl;
  private Drawable normalDrawable;
  private Drawable pressedDrawable;
  private pwf refreshUserInfoCallBack;
  private long uin;
  
  private PTSNodeImage(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  private String addSmartCrop(String paramString)
  {
    int i = getNodeInfo().getStyle().getWidth();
    int j = getNodeInfo().getStyle().getHeight();
    String str = paramString;
    if (i > 0)
    {
      str = paramString;
      if (j > 0) {
        str = pay.a(paramString, i, j);
      }
    }
    return str;
  }
  
  private void initRefreshUserInfoCallBack()
  {
    if (this.refreshUserInfoCallBack == null) {
      this.refreshUserInfoCallBack = new PTSNodeImage.1(this);
    }
  }
  
  private void loadAvatarByUin(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("PTSNodeImage", 1, "[loadAvatarByUin] uin is null");
    }
    for (;;)
    {
      return;
      try
      {
        long l = Long.parseLong(paramString);
        this.uin = l;
        initRefreshUserInfoCallBack();
        paramString = ReadInJoyUserInfoModule.a(l, this.refreshUserInfoCallBack);
        if (paramString != null)
        {
          paramString = ReadInJoyUserInfoModule.a(paramString);
          ((PTSImageView)getView()).setImageSrc(paramString);
          return;
        }
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("PTSNodeImage", 1, "[loadAvatarByUin] error, e = " + paramString);
      }
    }
  }
  
  private void setImageSrc(String paramString)
  {
    PTSTimeCostUtil.start("image-" + paramString);
    ((PTSImageView)getView()).setImageDrawable(((PTSImageView)getView()).getResources().getDrawable(2130841730));
    if (!TextUtils.isEmpty(paramString)) {
      if (qnv.a(paramString)) {
        setNetWorkImage(paramString);
      }
    }
    for (;;)
    {
      QLog.i("PTSNodeImage", 1, "[setImageSrc], imageUrl = " + paramString);
      PTSTimeCostUtil.end("image-" + paramString);
      return;
      if (qnv.b(paramString))
      {
        qnv.a((PTSImageView)getView(), paramString);
      }
      else
      {
        loadAvatarByUin(paramString);
        continue;
        QLog.i("PTSNodeImage", 1, "[setImageSrc] imageUrl is null.");
      }
    }
  }
  
  private void setNetWorkImage(String paramString)
  {
    paramString = addSmartCrop(paramString);
    PTSLog.i("PTSNodeImage", "[setImageSrc], cropUrl = " + paramString + ", blurRadius = " + this.blurRadius);
    if (this.blurRadius > 0.0F)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = ((PTSImageView)getView()).getResources().getDrawable(2130841730);
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setDecodeHandler(new bfpk((int)this.blurRadius));
      ((PTSImageView)getView()).setImageDrawable(paramString);
      return;
    }
    ((PTSImageView)getView()).setImageSrc(paramString);
  }
  
  private void updatePtsOnPressedSrc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    StateListDrawable localStateListDrawable;
    do
    {
      return;
      QLog.i("PTSNodeImage", 1, "[updatePtsOnPressedSrc], imageUrl = " + this.imageUrl + ", onPressedSrc = " + paramString + ", blurRadius = " + this.blurRadius);
      localStateListDrawable = new StateListDrawable();
      this.normalDrawable = qnv.a(getContext(), addSmartCrop(this.imageUrl), (int)this.blurRadius);
      this.pressedDrawable = qnv.a(getContext(), addSmartCrop(paramString), (int)this.blurRadius);
    } while ((this.normalDrawable == null) || (this.pressedDrawable == null));
    paramString = this.pressedDrawable;
    localStateListDrawable.addState(new int[] { 16842919 }, paramString);
    paramString = this.normalDrawable;
    localStateListDrawable.addState(new int[0], paramString);
    ((PTSImageView)getView()).setImageDrawable(localStateListDrawable);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    setImageSrc(this.imageUrl);
    updatePtsOnPressedSrc(getPtsOnPressSrc());
  }
  
  public boolean setAttribute(String paramString, Object paramObject)
  {
    boolean bool = super.setAttribute(paramString, paramObject);
    if ("src".equals(paramString))
    {
      this.imageUrl = PTSValueConvertUtil.getString(paramObject);
      bool = true;
    }
    return bool;
  }
  
  public boolean setStyle(String paramString, Object paramObject)
  {
    boolean bool = super.setStyle(paramString, paramObject);
    if ("filter".equalsIgnoreCase(paramString)) {
      this.blurRadius = PTSValueConvertUtil.getFloat(paramObject);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeImage
 * JD-Core Version:    0.7.0.1
 */