package com.dataline.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.util.file.FileUtil;
import com.dataline.util.widget.AsyncImageView;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.util.LocaleUtil;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.item.AIOSendMask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePathUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;

public class DatalineSessionAdapter
  extends TimeAdapter
{
  protected LayoutInflater a;
  protected Context b;
  protected LiteActivity c;
  protected QQAppInterface d;
  protected View.OnClickListener e = new DatalineSessionAdapter.2(this);
  private Drawable f = null;
  private Drawable h = null;
  private DataLineMsgSetList i;
  private int j = 0;
  private int k = 0;
  private boolean l = true;
  private int m = -1;
  
  public DatalineSessionAdapter(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    this.b = paramContext;
    this.i = paramDataLineMsgSetList;
    this.c = paramLiteActivity;
    this.d = paramQQAppInterface;
    this.m = this.i.size();
    this.a = LayoutInflater.from(this.b);
    this.j = this.b.getResources().getDimensionPixelSize(2131297157);
    this.k = this.b.getResources().getDimensionPixelSize(2131297156);
    d();
  }
  
  private void a(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (paramDrawable == null)
    {
      paramView.setBackgroundDrawable(null);
      return;
    }
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int n = paramView.getPaddingTop();
    int i1 = localRect.top;
    int i2 = paramView.getPaddingLeft();
    int i3 = localRect.left;
    int i4 = paramView.getPaddingRight();
    int i5 = localRect.right;
    int i6 = paramView.getPaddingBottom();
    int i7 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(i2 + i3, n + i1, i4 + i5, i6 + i7);
  }
  
  private void a(GridView paramGridView)
  {
    int n = (this.c.getWindowManager().getDefaultDisplay().getWidth() - AIOUtils.b(147.0F, this.c.getResources()) - 2) / 3;
    paramGridView.setNumColumns(3);
    paramGridView.setColumnWidth(n);
    paramGridView.setHorizontalSpacing(1);
    paramGridView.setSelector(new ColorDrawable(0));
    paramGridView.setTag(Integer.valueOf(n));
    paramGridView.setClickable(true);
    paramGridView.setLongClickable(true);
    paramGridView.setAddStatesFromChildren(true);
  }
  
  private void a(ItemHolder paramItemHolder, int paramInt1, int paramInt2)
  {
    try
    {
      localBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.b.getResources(), 2130838069), paramInt1, paramInt2, false);
      localObject1 = ImageUtil.a(localBitmap, AIOUtils.b(12.0F, this.c.getResources()));
      localObject2 = localObject1;
      if (localBitmap == null) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      Bitmap localBitmap;
      Object localObject1;
      Object localObject2;
      label61:
      label64:
      label67:
      break label64;
    }
    try
    {
      localBitmap.recycle();
      localObject2 = localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label61;
    }
    break label67;
    localObject1 = null;
    localObject2 = localObject1;
    if (QLog.isColorLevel())
    {
      QLog.e("DatalineSessionAdapter", 2, "DataLineSessionAdapter OOM");
      localObject2 = localObject1;
    }
    if (localObject2 != null)
    {
      localObject1 = new ClipDrawable(new BitmapDrawable(localObject2), 48, 2);
      paramItemHolder.d().b.setBackgroundDrawable((Drawable)localObject1);
      return;
    }
    paramItemHolder.d().b.setBackgroundDrawable(null);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = ForwardFileOption.b(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.b(10006);
    Intent localIntent = new Intent(this.b.getApplicationContext(), TroopFileDetailBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("forward_from_troop_file", true);
    localIntent.putExtra("not_forward", true);
    this.c.startActivityForResult(localIntent, 102);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, RelativeLayout paramRelativeLayout, ItemHolder paramItemHolder)
  {
    Object localObject;
    if ((paramDataLineMsgRecord.vipBubbleID == 100000L) && (paramDataLineMsgRecord.msgtype == -1000))
    {
      localObject = LocaleUtil.a(this.b.getApplicationContext());
      localObject = TranslateCache.b(this.b.getApplicationContext()).a(paramDataLineMsgRecord.msg, paramDataLineMsgRecord.msgId, (String)localObject);
      if ((localObject != null) && (((Trans_entity)localObject).c().booleanValue()) && (!paramDataLineMsgRecord.isSendFromLocal())) {
        paramItemHolder.c = BubbleUtils.a(100001, this.d, this.b.getResources(), this);
      } else {
        paramItemHolder.c = BubbleUtils.a(100000, this.d, this.b.getResources(), this);
      }
    }
    else
    {
      paramItemHolder.c = BubbleUtils.a(((ISVIPHandler)this.d.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b(paramDataLineMsgRecord), this.d, this.b.getResources(), this);
    }
    if (paramItemHolder.c != null)
    {
      paramItemHolder.c.a(paramRelativeLayout, null);
      boolean bool;
      if (paramDataLineMsgRecord.msgtype != -1000) {
        bool = true;
      } else {
        bool = false;
      }
      int n = paramDataLineMsgRecord.vipBubbleDiyTextId;
      if (n <= 0) {
        SVIPHandlerConstants.b(paramDataLineMsgRecord.vipBubbleID);
      }
      paramItemHolder.c.a(this.d, paramDataLineMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout, FontManagerConstants.getSenderUin(paramDataLineMsgRecord), n);
    }
    if ((paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009) || (paramDataLineMsgRecord.msgtype == -2009))
    {
      localObject = c(paramDataLineMsgRecord);
      if (localObject != null) {
        a(paramRelativeLayout, (Drawable)localObject);
      }
    }
    if (paramDataLineMsgRecord.msgtype == -2000) {
      a(paramRelativeLayout, null);
    }
    if (paramDataLineMsgRecord.msgtype == -1000) {
      a(paramItemHolder, paramRelativeLayout, paramDataLineMsgRecord, paramItemHolder.c);
    }
    a(paramRelativeLayout, paramDataLineMsgRecord);
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = ForwardFileOption.b(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.b(10002);
    Intent localIntent = new Intent(this.b.getApplicationContext(), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("not_forward", true);
    this.c.startActivityForResult(localIntent, 102);
  }
  
  private Drawable c(DataLineMsgRecord paramDataLineMsgRecord)
  {
    boolean bool = paramDataLineMsgRecord.isSendFromLocal();
    int n;
    if ((paramDataLineMsgRecord.msgtype != -2005) && (paramDataLineMsgRecord.msgtype != -2009)) {
      n = 0;
    } else {
      n = 1;
    }
    if (n == 0) {
      return null;
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      Drawable localDrawable = this.f;
      paramDataLineMsgRecord = localDrawable;
      if (localDrawable != null) {}
    }
    else
    {
      localObject = this.d.getApp().getResources();
      paramDataLineMsgRecord = ((Resources)localObject).getDrawable(2130852132);
      localObject = ((Resources)localObject).getDrawable(2130851950);
      this.f = paramDataLineMsgRecord;
      this.h = ((Drawable)localObject);
    }
    if (!bool) {
      return localObject;
    }
    return paramDataLineMsgRecord;
  }
  
  private boolean c(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return true;
    }
    if (paramItemHolder.c().d == null) {
      return false;
    }
    if (paramDataLineMsgSet == null) {
      return true;
    }
    int n = paramDataLineMsgSet.getCompletedCount();
    int i1 = paramDataLineMsgSet.getTotalCount();
    Object localObject = paramDataLineMsgSet.getFirstItem();
    if (localObject == null) {
      return false;
    }
    if ((paramDataLineMsgSet.getAt(0) != null) && (paramDataLineMsgSet.getAt(0).strMoloIconUrl != null)) {
      paramItemHolder.c().a.setAsyncImage(paramDataLineMsgSet.getAt(0).strMoloIconUrl);
    } else {
      paramItemHolder.c().a.setImageResource(2130845592);
    }
    if ((paramDataLineMsgSet.getTotalCount() >= 2) && (paramDataLineMsgSet.getAt(1) != null) && (paramDataLineMsgSet.getAt(1).strMoloIconUrl != null)) {
      paramItemHolder.c().b.setAsyncImage(paramDataLineMsgSet.getAt(1).strMoloIconUrl);
    } else {
      paramItemHolder.c().b.setImageResource(2130845592);
    }
    if ((paramDataLineMsgSet.getTotalCount() >= 3) && (paramDataLineMsgSet.getAt(2) != null) && (paramDataLineMsgSet.getAt(2).strMoloIconUrl != null)) {
      paramItemHolder.c().c.setAsyncImage(paramDataLineMsgSet.getAt(2).strMoloIconUrl);
    } else {
      paramItemHolder.c().c.setImageResource(2130845592);
    }
    if ((paramDataLineMsgSet.getTotalCount() >= 4) && (paramDataLineMsgSet.getAt(3) != null) && (paramDataLineMsgSet.getAt(3).strMoloIconUrl != null)) {
      paramItemHolder.c().d.setAsyncImage(paramDataLineMsgSet.getAt(3).strMoloIconUrl);
    } else {
      paramItemHolder.c().d.setImageResource(2130845592);
    }
    paramItemHolder.c().e.setText(FileManagerUtil.j(paramDataLineMsgSet.getFileNames()));
    if ((((DataLineMsgRecord)localObject).strMoloSource != null) && (((DataLineMsgRecord)localObject).strMoloSource.contains(this.b.getString(2131891362))))
    {
      paramItemHolder.c().f.setVisibility(8);
      paramItemHolder.c().e.setSingleLine(false);
      paramItemHolder.c().e.setMaxLines(2);
    }
    else
    {
      paramItemHolder.c().f.setVisibility(0);
      paramItemHolder.c().f.setText(2131891263);
      paramItemHolder.c().e.setSingleLine(true);
    }
    paramItemHolder.c().g.setText(FileUtil.a(paramDataLineMsgSet.getFileTotalSize()));
    if ((((DataLineMsgRecord)localObject).strMoloSource != null) && (!((DataLineMsgRecord)localObject).strMoloSource.equals("")))
    {
      paramItemHolder.c().k.setText(((DataLineMsgRecord)localObject).strMoloSource);
      paramItemHolder.c().k.setVisibility(0);
      paramItemHolder.c().i.setVisibility(0);
    }
    else
    {
      paramItemHolder.c().i.setVisibility(8);
    }
    if ((((DataLineMsgRecord)localObject).strMoloSrcIconUrl != null) && (!((DataLineMsgRecord)localObject).strMoloSrcIconUrl.equals("")))
    {
      paramItemHolder.c().j.setImageURL(((DataLineMsgRecord)localObject).strMoloSrcIconUrl);
      paramItemHolder.c().j.setVisibility(0);
    }
    else
    {
      paramItemHolder.c().j.setVisibility(8);
    }
    if (paramDataLineMsgSet.isCanceled())
    {
      paramItemHolder.c().h.setText(2131891328);
    }
    else if (paramDataLineMsgSet.isFileComing())
    {
      paramItemHolder.c().h.setText(2131889346);
    }
    else
    {
      StringBuilder localStringBuilder;
      if (n == i1)
      {
        localObject = paramItemHolder.c().h;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i1);
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
      else
      {
        localObject = paramItemHolder.c().h;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(n);
        localStringBuilder.append("/");
        localStringBuilder.append(i1);
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
    }
    if (((!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) || (paramDataLineMsgSet.isFileComing()))
    {
      paramItemHolder.c().l.setVisibility(4);
      return true;
    }
    paramItemHolder.c().l.setVisibility(0);
    paramItemHolder.c().l.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    return true;
  }
  
  private void d(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return;
    }
    if (paramDataLineMsgSet == null) {
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return;
    }
    String str = FilePathUtil.b(localDataLineMsgRecord.path);
    paramItemHolder.d().a.setAsyncClipSize(this.j, this.k);
    paramItemHolder.d().a.setDefaultImageByMargin();
    paramItemHolder.d().a.setIsDrawRound(true);
    paramItemHolder.d().e.setVisibility(8);
    paramItemHolder.d().f.setVisibility(8);
    if ((str != null) && (new VFSFile(str).exists())) {
      paramItemHolder.d().a.setAsyncImage(str);
    } else if ((localDataLineMsgRecord.thumbPath != null) && (localDataLineMsgRecord.thumbPath.length() > 0)) {
      paramItemHolder.d().a.setAsyncImage(localDataLineMsgRecord.thumbPath);
    } else {
      paramItemHolder.d().a.setImageDrawableDefault();
    }
    if ((localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L))
    {
      if (localDataLineMsgRecord.isSendFromLocal())
      {
        paramItemHolder.d().b.setVisibility(0);
        int n = (int)(localDataLineMsgRecord.progress * 100.0F);
        paramItemHolder.d().b.setProgress(n);
      }
      else
      {
        paramItemHolder.d().c.setVisibility(0);
      }
    }
    else
    {
      paramItemHolder.d().b.setVisibility(8);
      paramItemHolder.d().c.setVisibility(8);
      if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.thumbPath == null))
      {
        paramItemHolder.d().f.setVisibility(0);
        paramItemHolder.d().f.setText(2131891280);
      }
      else
      {
        paramItemHolder.d().f.setVisibility(8);
      }
    }
    if (!paramDataLineMsgSet.isSendFromLocal())
    {
      paramItemHolder.d().h.setVisibility(8);
      if (localDataLineMsgRecord.strMoloKey != null)
      {
        if ((localDataLineMsgRecord.strMoloSource != null) && (!localDataLineMsgRecord.strMoloSource.equals("")))
        {
          paramItemHolder.d().j.setText(localDataLineMsgRecord.strMoloSource);
          paramItemHolder.d().j.setVisibility(0);
          paramItemHolder.d().h.setVisibility(0);
        }
        else
        {
          paramItemHolder.d().h.setVisibility(8);
        }
        if ((localDataLineMsgRecord.strMoloSrcIconUrl != null) && (!localDataLineMsgRecord.strMoloSrcIconUrl.equals("")))
        {
          paramItemHolder.d().i.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramItemHolder.d().i.setVisibility(0);
        }
        else
        {
          paramItemHolder.d().i.setVisibility(8);
        }
      }
    }
    if (paramItemHolder.d().d != null) {
      paramItemHolder.d().d.setContentDescription(HardCodeUtil.a(2131900900));
    }
    if (paramItemHolder.d().a != null) {
      paramItemHolder.d().a.setContentDescription(HardCodeUtil.a(2131900892));
    }
  }
  
  private boolean e(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return true;
    }
    if (paramItemHolder.e().a == null) {
      return false;
    }
    if (paramDataLineMsgSet == null) {
      return true;
    }
    int i1 = paramDataLineMsgSet.getCompletedCount();
    int n = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    StringBuilder localStringBuilder;
    if (i1 == n)
    {
      localObject = paramItemHolder.e().a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(n);
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    else
    {
      localObject = paramItemHolder.e().a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(i1);
      localStringBuilder.append("/");
      localStringBuilder.append(n);
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    i1 = ((Integer)paramItemHolder.e().b.getTag()).intValue();
    Object localObject = (DatalineSessionAdapter.GridAdapter)paramItemHolder.e().b.getAdapter();
    if (localObject == null)
    {
      localObject = new DatalineSessionAdapter.GridAdapter(this, paramItemHolder, paramDataLineMsgSet, i1, null);
      paramItemHolder.e().b.setAdapter((ListAdapter)localObject);
    }
    else
    {
      ((DatalineSessionAdapter.GridAdapter)localObject).a = paramDataLineMsgSet;
      ((DatalineSessionAdapter.GridAdapter)localObject).b = paramItemHolder;
      ((DatalineSessionAdapter.GridAdapter)localObject).a();
    }
    paramItemHolder.e().e.setVisibility(8);
    paramDataLineMsgSet.printlog();
    if (((!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) || (paramDataLineMsgSet.isFileComing()))
    {
      paramItemHolder.e().c.setVisibility(4);
      if (paramDataLineMsgSet.isCanceled())
      {
        paramItemHolder.e().e.setVisibility(0);
        paramItemHolder.e().f.setText(2131891328);
      }
      else if (paramDataLineMsgSet.isFileComing())
      {
        paramItemHolder.e().e.setVisibility(0);
        paramItemHolder.e().f.setText(2131889346);
      }
    }
    else
    {
      paramItemHolder.e().c.setVisibility(0);
      paramItemHolder.e().c.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    }
    if (!paramDataLineMsgSet.isSendFromLocal())
    {
      paramItemHolder.e().g.setVisibility(8);
      if (localDataLineMsgRecord.strMoloKey != null)
      {
        if ((localDataLineMsgRecord.strMoloSource != null) && (!localDataLineMsgRecord.strMoloSource.equals("")))
        {
          paramItemHolder.e().i.setText(localDataLineMsgRecord.strMoloSource);
          paramItemHolder.e().i.setVisibility(0);
          paramItemHolder.e().g.setVisibility(0);
        }
        else
        {
          paramItemHolder.e().g.setVisibility(8);
        }
        if ((localDataLineMsgRecord.strMoloSrcIconUrl != null) && (!localDataLineMsgRecord.strMoloSrcIconUrl.equals("")))
        {
          paramItemHolder.e().h.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramItemHolder.e().h.setVisibility(0);
        }
        else
        {
          paramItemHolder.e().h.setVisibility(8);
        }
      }
    }
    if (paramItemHolder.e().d != null)
    {
      paramDataLineMsgSet = String.format(this.b.getString(2131891311), new Object[] { Integer.valueOf(n) });
      paramItemHolder.e().d.setContentDescription(paramDataLineMsgSet);
    }
    return true;
  }
  
  private void f(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return;
    }
    if (paramDataLineMsgSet == null) {
      return;
    }
    paramItemHolder.a.setTag(paramItemHolder);
    int n;
    if ((paramDataLineMsgSet.isSendFromLocal()) && (paramDataLineMsgSet.hasFailed()) && (!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) {
      n = 1;
    } else {
      n = 0;
    }
    if (n == 0)
    {
      paramItemHolder.a.setVisibility(4);
      return;
    }
    paramItemHolder.a.setVisibility(0);
    if (paramDataLineMsgSet.getOpType() == 1)
    {
      paramItemHolder.a.setOnClickListener(this.c.O);
      return;
    }
    paramItemHolder.a.setOnClickListener(this.c.N);
  }
  
  private boolean f()
  {
    DataLineMsgSetList localDataLineMsgSetList = this.i;
    return (localDataLineMsgSetList == null) || (localDataLineMsgSetList.size() == 0);
  }
  
  protected View a(int paramInt, ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    return null;
  }
  
  protected void a()
  {
    this.l = false;
    new Handler().postDelayed(new DatalineSessionAdapter.1(this), 1500L);
  }
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    if (paramListView == null) {
      return;
    }
    int n = this.i.getSetIndex(paramLong);
    if (n == -1) {
      return;
    }
    paramListView = paramListView.getChildAt(n - paramListView.getFirstVisiblePosition());
    if (paramListView == null) {
      return;
    }
    if (n >= this.i.size()) {
      return;
    }
    DataLineMsgSet localDataLineMsgSet = this.i.get(n);
    if (localDataLineMsgSet.mUpdateProcessTick == 0L)
    {
      localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();
    }
    else
    {
      if (System.currentTimeMillis() - localDataLineMsgSet.mUpdateProcessTick < 1000L) {
        return;
      }
      localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();
    }
    int i1;
    Object localObject;
    if (localDataLineMsgSet.isSingle())
    {
      i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
      localObject = this.d.getMessageFacade().d(i1).a(paramLong);
      if (localObject == null) {
        return;
      }
      if (a(getItemViewType(n)))
      {
        a((DataLineMsgRecord)localObject, paramListView, paramFloat);
        return;
      }
      float f1 = paramFloat;
      if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
        f1 = ((DataLineMsgRecord)localObject).progress;
      }
      n = ((DataLineMsgRecord)localObject).msgtype;
      if ((n != -2335) && (n != -2009) && (n != -2005))
      {
        if (n != -2000) {
          return;
        }
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131435380);
        if (paramListView != null) {
          paramListView.setProgress((int)(f1 * 100.0F));
        }
      }
      else if (((DataLineMsgRecord)localObject).bIsMoloImage)
      {
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131435380);
        if (paramListView != null) {
          paramListView.setProgress((int)(f1 * 100.0F));
        }
      }
      else
      {
        localObject = (TextView)paramListView.findViewById(2131433146);
        paramListView = (ProgressBar)paramListView.findViewById(2131433115);
        if (paramListView != null)
        {
          paramListView.setVisibility(0);
          paramListView.setProgress((int)(f1 * 100.0F));
        }
        if (localObject != null)
        {
          paramListView = new StringBuilder();
          paramListView.append((int)(f1 * 100.0F));
          paramListView.append("%");
          ((TextView)localObject).setText(paramListView.toString());
        }
      }
    }
    else
    {
      paramListView = (ItemHolder)paramListView.getTag();
      if (paramListView == null) {
        return;
      }
      n = localDataLineMsgSet.getGroupType();
      localObject = null;
      if ((n != -2335) && (n != -2009) && (n != -2005))
      {
        if (n != -2000) {
          paramListView = null;
        } else {
          paramListView = paramListView.e().c;
        }
      }
      else
      {
        localObject = paramListView.c().h;
        paramListView = paramListView.c().l;
      }
      n = localDataLineMsgSet.getCompletedCount();
      i1 = localDataLineMsgSet.getTotalCount();
      if (localObject != null)
      {
        StringBuilder localStringBuilder;
        if (n == i1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(i1);
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(n);
          localStringBuilder.append("/");
          localStringBuilder.append(i1);
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
      }
      if (paramListView != null)
      {
        if (n == i1)
        {
          paramListView.setVisibility(4);
          return;
        }
        paramListView.setVisibility(0);
        paramListView.setProgress((int)(localDataLineMsgSet.getTotalProcess() * 100.0F));
      }
    }
  }
  
  protected void a(View paramView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.k, BaseChatItemLayout.getBubblePaddingAlignHead(), BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignHead(), BaseChatItemLayout.k, BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.l);
  }
  
  protected void a(ItemHolder paramItemHolder, View paramView, DataLineMsgRecord paramDataLineMsgRecord, BubbleInfo paramBubbleInfo)
  {
    if (paramBubbleInfo == null) {
      return;
    }
    if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.b()))
    {
      if (paramBubbleInfo.l == 0) {
        paramItemHolder.f().a.setTextColor(-16777216);
      } else {
        paramItemHolder.f().a.setTextColor(paramBubbleInfo.l);
      }
      if (paramBubbleInfo.m == 0)
      {
        paramItemHolder.f().a.setLinkTextColor(paramView.getResources().getColorStateList(2131168018));
        return;
      }
      paramItemHolder.f().a.setLinkTextColor(paramBubbleInfo.m);
      return;
    }
    paramView = paramView.getResources();
    int n;
    if (paramDataLineMsgRecord.isSendFromLocal()) {
      n = 2131168020;
    } else {
      n = 2131168016;
    }
    paramBubbleInfo = paramView.getColorStateList(n);
    paramItemHolder.f().a.setTextColor(paramBubbleInfo);
    if (paramDataLineMsgRecord.isSendFromLocal()) {
      paramView = paramView.getColorStateList(2131168019);
    } else {
      paramView = paramView.getColorStateList(2131168018);
    }
    paramItemHolder.f().a.setLinkTextColor(paramView);
  }
  
  protected void a(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return;
    }
    if (paramDataLineMsgSet == null) {
      return;
    }
    paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    if (paramDataLineMsgSet == null) {
      return;
    }
    int n = (int)(paramDataLineMsgSet.progress * 100.0F);
    paramItemHolder.c().a.setIsDrawRound(false);
    FileManagerUtil.a(paramItemHolder.c().a, paramDataLineMsgSet);
    paramItemHolder.c().e.setText(FileManagerUtil.j(paramDataLineMsgSet.filename));
    paramItemHolder.c().g.setText(FileUtil.a(paramDataLineMsgSet.filesize));
    TextView localTextView;
    StringBuilder localStringBuilder;
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      if (paramDataLineMsgSet.fileMsgStatus == 2L)
      {
        paramItemHolder.c().h.setText(2131891328);
      }
      else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
      {
        paramItemHolder.c().h.setText(2131889345);
      }
      else if (!paramDataLineMsgSet.issuc)
      {
        if (paramDataLineMsgSet.nOpType == 1) {
          paramItemHolder.c().h.setText(2131889343);
        } else {
          paramItemHolder.c().h.setText(2131889344);
        }
      }
      else
      {
        localTextView = paramItemHolder.c().h;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(n);
        localStringBuilder.append("%");
        localTextView.setText(localStringBuilder.toString());
      }
    }
    else if (paramDataLineMsgSet.fileMsgStatus == 2L)
    {
      paramItemHolder.c().h.setText(2131891328);
    }
    else if (paramDataLineMsgSet.fileMsgStatus == 1L)
    {
      paramItemHolder.c().h.setText(2131889346);
    }
    else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
    {
      paramItemHolder.c().h.setText(2131889337);
    }
    else if (!paramDataLineMsgSet.issuc)
    {
      paramItemHolder.c().h.setText(2131889343);
    }
    else
    {
      localTextView = paramItemHolder.c().h;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(n);
      localStringBuilder.append("%");
      localTextView.setText(localStringBuilder.toString());
    }
    if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L))
    {
      paramItemHolder.c().l.setVisibility(0);
      paramItemHolder.c().l.setProgress(n);
      return;
    }
    paramItemHolder.c().l.setVisibility(4);
  }
  
  protected void a(DataLineMsgRecord paramDataLineMsgRecord, View paramView, float paramFloat) {}
  
  public void a(DataLineMsgSetList paramDataLineMsgSetList)
  {
    this.i = paramDataLineMsgSetList;
  }
  
  protected boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(long paramLong, ListView paramListView)
  {
    int n = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    Object localObject = this.d.getDataLineMsgProxy(n).b(paramLong);
    if (f()) {
      return false;
    }
    if (paramListView == null) {
      return true;
    }
    n = this.i.getSetIndex(paramLong);
    if (n == -1) {
      return false;
    }
    View localView = paramListView.getChildAt(n - paramListView.getFirstVisiblePosition());
    if (localView == null) {
      return false;
    }
    if (n >= this.i.size()) {
      return false;
    }
    paramListView = this.i.get(n);
    if ((localObject != null) && (((DataLineMsgRecord)localObject).fileMsgStatus == 1L)) {
      if (paramListView.mUpdateMutiViewTick == 0L)
      {
        paramListView.mUpdateMutiViewTick = System.currentTimeMillis();
      }
      else
      {
        if (System.currentTimeMillis() - paramListView.mUpdateMutiViewTick < 1000L) {
          return true;
        }
        paramListView.mUpdateMutiViewTick = System.currentTimeMillis();
      }
    }
    if (paramListView.isSingle()) {
      return true;
    }
    localObject = (ItemHolder)localView.getTag();
    if (localObject == null) {
      return false;
    }
    n = paramListView.getGroupType();
    if (n != -2335)
    {
      if ((n == -2000) && (!e((ItemHolder)localObject, paramListView))) {
        return false;
      }
    }
    else if (paramListView.getFirstItem().bIsMoloImage)
    {
      if (!e((ItemHolder)localObject, paramListView)) {
        return false;
      }
    }
    else if (!c((ItemHolder)localObject, paramListView)) {
      return false;
    }
    f((ItemHolder)localObject, paramListView);
    return true;
  }
  
  public long b(int paramInt)
  {
    return this.i.get(paramInt).getTime();
  }
  
  protected void b(int paramInt, ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet) {}
  
  protected void b(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return;
    }
    if (paramDataLineMsgSet == null) {
      return;
    }
    paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    if (paramDataLineMsgSet == null) {
      return;
    }
    int n = (int)(paramDataLineMsgSet.progress * 100.0F);
    if (paramDataLineMsgSet.strMoloIconUrl != null) {
      paramItemHolder.c().a.setAsyncImage(paramDataLineMsgSet.strMoloIconUrl);
    } else {
      paramItemHolder.c().a.setImageResource(2130845592);
    }
    paramItemHolder.c().e.setText(FileManagerUtil.j(paramDataLineMsgSet.filename));
    if ((paramDataLineMsgSet.strMoloSource != null) && (paramDataLineMsgSet.strMoloSource.contains(this.b.getString(2131891362))))
    {
      paramItemHolder.c().f.setVisibility(8);
      paramItemHolder.c().e.setSingleLine(false);
      paramItemHolder.c().e.setMaxLines(2);
    }
    else
    {
      paramItemHolder.c().f.setVisibility(0);
      paramItemHolder.c().f.setText(2131891263);
      paramItemHolder.c().e.setSingleLine(true);
    }
    paramItemHolder.c().g.setText(FileUtil.a(paramDataLineMsgSet.filesize));
    if ((paramDataLineMsgSet.strMoloSource != null) && (!paramDataLineMsgSet.strMoloSource.equals("")))
    {
      paramItemHolder.c().k.setText(paramDataLineMsgSet.strMoloSource);
      paramItemHolder.c().k.setVisibility(0);
      paramItemHolder.c().i.setVisibility(0);
    }
    else
    {
      paramItemHolder.c().i.setVisibility(8);
    }
    if ((paramDataLineMsgSet.strMoloSrcIconUrl != null) && (!paramDataLineMsgSet.strMoloSrcIconUrl.equals("")))
    {
      paramItemHolder.c().j.setImageURL(paramDataLineMsgSet.strMoloSrcIconUrl);
      paramItemHolder.c().j.setVisibility(0);
    }
    else
    {
      paramItemHolder.c().j.setVisibility(8);
    }
    if (paramDataLineMsgSet.fileMsgStatus == 2L)
    {
      paramItemHolder.c().h.setText(2131891328);
    }
    else if (paramDataLineMsgSet.fileMsgStatus == 1L)
    {
      paramItemHolder.c().h.setText(2131889346);
    }
    else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
    {
      paramItemHolder.c().h.setText(2131889337);
    }
    else if (!paramDataLineMsgSet.issuc)
    {
      paramItemHolder.c().h.setText(2131889343);
    }
    else
    {
      TextView localTextView = paramItemHolder.c().h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(n);
      localStringBuilder.append("%");
      localTextView.setText(localStringBuilder.toString());
    }
    if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L))
    {
      paramItemHolder.c().l.setVisibility(0);
      paramItemHolder.c().l.setProgress(n);
      return;
    }
    paramItemHolder.c().l.setVisibility(4);
  }
  
  protected boolean b()
  {
    return this.l;
  }
  
  public int c()
  {
    return this.i.size();
  }
  
  public long c(int paramInt)
  {
    return this.i.get(paramInt).getMsgId();
  }
  
  public int getCount()
  {
    if (f()) {
      return 1;
    }
    return this.i.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (f()) {
      return null;
    }
    return this.i.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (f()) {
      return 13;
    }
    DataLineMsgSet localDataLineMsgSet = this.i.get(paramInt);
    boolean bool = localDataLineMsgSet.isSendFromLocal();
    int i1 = localDataLineMsgSet.getGroupType();
    if (i1 != -5041)
    {
      if (i1 != -5000)
      {
        paramInt = 1;
        int n = 2;
        if (i1 != -2335)
        {
          if (i1 != -2073)
          {
            if ((i1 != -2009) && (i1 != -2005))
            {
              if (i1 != -2000)
              {
                if (i1 != -1000) {
                  return 12;
                }
                if (bool) {
                  return 7;
                }
                return 0;
              }
              if (localDataLineMsgSet.isSingle())
              {
                if (bool) {
                  paramInt = 8;
                }
                return paramInt;
              }
              paramInt = n;
              if (bool) {
                paramInt = 9;
              }
              return paramInt;
            }
            if (localDataLineMsgSet.isSingle())
            {
              if (bool) {
                return 10;
              }
              return 3;
            }
            if (bool) {
              return 11;
            }
            return 4;
          }
          return 16;
        }
        DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
        if (localDataLineMsgSet.isSingle())
        {
          if (localDataLineMsgRecord.bIsMoloImage) {
            return 1;
          }
          return 5;
        }
        if (localDataLineMsgRecord.bIsMoloImage) {
          return 2;
        }
        return 6;
      }
      return 14;
    }
    return 15;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = f();
    Object localObject2 = null;
    Object localObject1;
    Object localObject3;
    if (bool)
    {
      if (paramView == null)
      {
        localObject1 = new ItemHolder();
        paramView = this.a.inflate(2131624671, null);
        localObject2 = (TextView)paramView.findViewById(2131437345);
        localObject3 = (ImageView)paramView.findViewById(2131437344);
        if (this.c.j == 1)
        {
          ((TextView)localObject2).setText(2131888330);
          ((ImageView)localObject3).setImageResource(2130839755);
        }
        paramView.setTag(localObject1);
      }
      else
      {
        localObject1 = (ItemHolder)paramView.getTag();
      }
      paramView.setVisibility(4);
      this.c.x();
    }
    label3897:
    for (;;)
    {
      localObject1 = paramView;
      break;
      this.c.x();
      localObject3 = this.i.get(paramInt);
      if (localObject3 == null)
      {
        localObject1 = paramView;
        paramView = (View)localObject2;
        break;
      }
      int n = getItemViewType(paramInt);
      DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgSet)localObject3).getFirstItem();
      Object localObject4;
      int i1;
      if (paramView == null)
      {
        localObject2 = new ItemHolder();
        if (a(n))
        {
          paramView = a(n, (ItemHolder)localObject2, (DataLineMsgSet)localObject3);
        }
        else if (n == 12)
        {
          localObject1 = this.a.inflate(2131624659, null);
          ((ItemHolder)localObject2).b((TextView)((View)localObject1).findViewById(2131431624));
          paramView = (View)localObject1;
          if (((ItemHolder)localObject2).k() != null)
          {
            ((ItemHolder)localObject2).k().setText(2131891319);
            paramView = (View)localObject1;
          }
        }
        else
        {
          Object localObject5;
          if (n == 14)
          {
            paramView = this.a.inflate(2131624645, null);
            localObject1 = ((ItemHolder)localObject2).g();
            ((ItemHolder.GrayTipItemHolder)localObject1).a = ((TextView)paramView.findViewById(2131434371));
            localObject4 = HardCodeUtil.a(2131900911);
            localObject5 = HardCodeUtil.a(2131900888);
            ((ItemHolder.GrayTipItemHolder)localObject1).a.setMaxLines(2);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("还想把文件发到好友手机？快来用\n");
            localStringBuilder.append((String)localObject4);
            localStringBuilder.append((String)localObject5);
            localObject5 = new SpannableString(localStringBuilder.toString());
            ((SpannableString)localObject5).setSpan(new DatalineSessionAdapter.3(this), 16, ((String)localObject4).length() + 16, 33);
            ((ItemHolder.GrayTipItemHolder)localObject1).a.setHighlightColor(0);
            ((ItemHolder.GrayTipItemHolder)localObject1).a.setText((CharSequence)localObject5);
            ((ItemHolder.GrayTipItemHolder)localObject1).a.setMovementMethod(LinkMovementMethod.getInstance());
            ((ItemHolder.GrayTipItemHolder)localObject1).a.setVisibility(8);
          }
          else if (n == 15)
          {
            localObject1 = ((ItemHolder)localObject2).h();
            paramView = LayoutInflater.from(this.b).inflate(2131627106, null);
            ((ItemHolder.TipHolder)localObject1).a = ((TextView)paramView.findViewById(2131434371));
          }
          else
          {
            if (n == 16)
            {
              localObject1 = ((ItemHolder)localObject2).h();
              paramView = LayoutInflater.from(this.b).inflate(2131624481, null);
              ((ItemHolder.TipHolder)localObject1).a = ((TextView)paramView.findViewById(2131434371));
              ((ItemHolder.TipHolder)localObject1).a.setMovementMethod(null);
              ((ItemHolder.TipHolder)localObject1).a.setTextColor(paramView.getResources().getColorStateList(2131165715));
            }
            for (;;)
            {
              break;
              if (!((DataLineMsgSet)localObject3).isSendFromLocal())
              {
                localObject1 = this.a.inflate(2131624660, null);
                localObject4 = (ImageView)((View)localObject1).findViewById(2131435219);
                paramView = this.c.getResources().getDrawable(2130845599);
                i1 = DataLineMsgRecord.getDevTypeBySet((DataLineMsgSet)localObject3);
                if (i1 == 0) {
                  paramView = this.c.getResources().getDrawable(2130845599);
                } else if (i1 == 1) {
                  paramView = this.c.getResources().getDrawable(2130845594);
                }
                ((ImageView)localObject4).setImageDrawable(paramView);
                paramView = (View)localObject1;
              }
              else
              {
                paramView = this.a.inflate(2131624666, null);
              }
              ((ItemHolder)localObject2).b = ((RelativeLayout)paramView.findViewById(2131438925));
              ((ItemHolder)localObject2).b.setTag(localObject2);
              ((ItemHolder)localObject2).b.setClickable(true);
              ((ItemHolder)localObject2).b.setLongClickable(true);
              ((ItemHolder)localObject2).b.setOnClickListener(this.e);
              ((ItemHolder)localObject2).b.setOnLongClickListener(this.c.R);
              ((ItemHolder)localObject2).b.setOnTouchListener(this.c.S);
              ((ItemHolder)localObject2).b.setAddStatesFromChildren(true);
              switch (n)
              {
              case 4: 
              default: 
                break;
              case 6: 
                localObject1 = (RelativeLayout)this.a.inflate(2131624648, null);
                ((ItemHolder)localObject2).b.addView((View)localObject1);
                ((ItemHolder)localObject2).c().m = ((RelativeLayout)localObject1);
                ((ItemHolder)localObject2).c().a = ((AsyncImageView)paramView.findViewById(2131433105));
                ((ItemHolder)localObject2).c().b = ((AsyncImageView)paramView.findViewById(2131433106));
                ((ItemHolder)localObject2).c().c = ((AsyncImageView)paramView.findViewById(2131433107));
                ((ItemHolder)localObject2).c().d = ((AsyncImageView)paramView.findViewById(2131433108));
                ((ItemHolder)localObject2).c().e = ((TextView)paramView.findViewById(2131433141));
                ((ItemHolder)localObject2).c().f = ((TextView)paramView.findViewById(2131433118));
                ((ItemHolder)localObject2).c().g = ((TextView)paramView.findViewById(2131433145));
                ((ItemHolder)localObject2).c().h = ((TextView)paramView.findViewById(2131433146));
                ((ItemHolder)localObject2).c().l = ((ProgressBar)paramView.findViewById(2131433115));
                ((ItemHolder)localObject2).c().k = ((TextView)paramView.findViewById(2131448956));
                ((ItemHolder)localObject2).c().j = ((URLImageView)paramView.findViewById(2131435261));
                ((ItemHolder)localObject2).c().i = ((LinearLayout)paramView.findViewById(2131446180));
                ((ItemHolder)localObject2).c().a.setDefaultImage(2130845592);
                ((ItemHolder)localObject2).c().b.setDefaultImage(2130845592);
                ((ItemHolder)localObject2).c().c.setDefaultImage(2130845592);
                ((ItemHolder)localObject2).c().d.setDefaultImage(2130845592);
                ((ItemHolder)localObject2).c().a.setIsDrawRound(false);
                ((ItemHolder)localObject2).c().b.setIsDrawRound(false);
                ((ItemHolder)localObject2).c().c.setIsDrawRound(false);
                ((ItemHolder)localObject2).c().d.setIsDrawRound(false);
                break;
              case 5: 
                localObject1 = (RelativeLayout)this.a.inflate(2131624639, null);
                ((ItemHolder)localObject2).b.addView((View)localObject1);
                ((ItemHolder)localObject2).c().m = ((RelativeLayout)localObject1);
                ((ItemHolder)localObject2).c().a = ((AsyncImageView)paramView.findViewById(2131433104));
                ((ItemHolder)localObject2).c().e = ((TextView)paramView.findViewById(2131433141));
                ((ItemHolder)localObject2).c().f = ((TextView)paramView.findViewById(2131433118));
                ((ItemHolder)localObject2).c().g = ((TextView)paramView.findViewById(2131433145));
                ((ItemHolder)localObject2).c().h = ((TextView)paramView.findViewById(2131433146));
                ((ItemHolder)localObject2).c().l = ((ProgressBar)paramView.findViewById(2131433115));
                ((ItemHolder)localObject2).c().k = ((TextView)paramView.findViewById(2131448956));
                ((ItemHolder)localObject2).c().j = ((URLImageView)paramView.findViewById(2131435261));
                ((ItemHolder)localObject2).c().i = ((LinearLayout)paramView.findViewById(2131446180));
                ((ItemHolder)localObject2).c().a.setDefaultImage(2130845591);
                ((ItemHolder)localObject2).c().a.setIsDrawRound(false);
                break;
              case 3: 
              case 10: 
                localObject4 = (RelativeLayout)this.a.inflate(2131624641, null);
                ((ItemHolder)localObject2).b.addView((View)localObject4);
                if (FontSettingManager.getFontLevel() > 17.0F)
                {
                  ((ItemHolder)localObject2).c().m = ((RelativeLayout)localObject4);
                  i1 = AIOUtils.b(70.0F, this.b.getResources());
                  localObject1 = (RelativeLayout)paramView.findViewById(2131433128);
                  localObject5 = new RelativeLayout.LayoutParams(-1, i1);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(10, 2131433131);
                  ((RelativeLayout)localObject4).updateViewLayout((View)localObject1, (ViewGroup.LayoutParams)localObject5);
                  localObject4 = (AsyncImageView)paramView.findViewById(2131433104);
                  ((AsyncImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
                  localObject5 = new RelativeLayout.LayoutParams(i1, i1);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(9, 2131433128);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(15, 2131433128);
                  ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
                  ((ItemHolder)localObject2).c().a = ((AsyncImageView)localObject4);
                  localObject4 = (TextView)paramView.findViewById(2131433141);
                  ((TextView)localObject4).setGravity(16);
                  localObject5 = new RelativeLayout.LayoutParams(-1, -2);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131433104);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131433128);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(10, 2131433128);
                  ((RelativeLayout.LayoutParams)localObject5).setMargins(AIOUtils.b(10.0F, this.b.getResources()), 0, 0, 0);
                  ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
                  ((ItemHolder)localObject2).c().e = ((TextView)localObject4);
                  localObject4 = (TextView)paramView.findViewById(2131433146);
                  ((TextView)localObject4).setGravity(5);
                  localObject5 = new RelativeLayout.LayoutParams(-2, -2);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131433128);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(12, 2131433128);
                  ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
                  ((ItemHolder)localObject2).c().h = ((TextView)localObject4);
                  localObject4 = (TextView)paramView.findViewById(2131433145);
                  ((TextView)localObject4).setGravity(17);
                  localObject5 = new RelativeLayout.LayoutParams(-2, -2);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131433128);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(2, 2131433146);
                  ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
                  ((ItemHolder)localObject2).c().g = ((TextView)localObject4);
                }
                else
                {
                  ((ItemHolder)localObject2).c().m = ((RelativeLayout)localObject4);
                  ((ItemHolder)localObject2).c().a = ((AsyncImageView)paramView.findViewById(2131433104));
                  ((ItemHolder)localObject2).c().e = ((TextView)paramView.findViewById(2131433141));
                  ((ItemHolder)localObject2).c().g = ((TextView)paramView.findViewById(2131433145));
                  ((ItemHolder)localObject2).c().h = ((TextView)paramView.findViewById(2131433146));
                }
                ((ItemHolder)localObject2).c().l = ((ProgressBar)paramView.findViewById(2131433115));
                ((ItemHolder)localObject2).c().a.setDefaultImage(2130853415);
                ((ItemHolder)localObject2).c().a.setIsDrawRound(false);
                break;
              case 2: 
              case 9: 
                localObject1 = (RelativeLayout)this.a.inflate(2131624649, null);
                ((ItemHolder)localObject2).b.addView((View)localObject1);
                ((ItemHolder)localObject2).e().d = ((RelativeLayout)localObject1);
                ((ItemHolder)localObject2).e().a = ((TextView)paramView.findViewById(2131440270));
                ((ItemHolder)localObject2).e().b = ((GridView)paramView.findViewById(2131440243));
                ((ItemHolder)localObject2).e().c = ((ProgressBar)paramView.findViewById(2131433115));
                ((ItemHolder)localObject2).e().e = ((LinearLayout)paramView.findViewById(2131446328));
                ((ItemHolder)localObject2).e().f = ((TextView)paramView.findViewById(2131448957));
                if (!((DataLineMsgSet)localObject3).isSendFromLocal())
                {
                  ((ItemHolder)localObject2).e().i = ((TextView)paramView.findViewById(2131448956));
                  ((ItemHolder)localObject2).e().h = ((URLImageView)paramView.findViewById(2131435261));
                  ((ItemHolder)localObject2).e().g = ((LinearLayout)paramView.findViewById(2131446180));
                }
                ((ItemHolder)localObject2).e().d.setAddStatesFromChildren(true);
                ((ItemHolder)localObject2).e().a.setTag(localObject2);
                ((ItemHolder)localObject2).e().a.setOnClickListener(this.e);
                ((ItemHolder)localObject2).e().a.setClickable(true);
                ((ItemHolder)localObject2).e().a.setOnLongClickListener(this.c.R);
                ((ItemHolder)localObject2).e().a.setOnTouchListener(this.c.S);
                ((ItemHolder)localObject2).e().a.setLongClickable(true);
                a(((ItemHolder)localObject2).e().b);
                break;
              case 1: 
              case 8: 
                localObject1 = (RelativeLayout)this.a.inflate(2131624647, null);
                ((ItemHolder)localObject2).b.addView((View)localObject1);
                ((ItemHolder)localObject2).b.setGravity(17);
                ((ItemHolder)localObject2).d().d = ((RelativeLayout)localObject1);
                ((ItemHolder)localObject2).d().a = ((AsyncImageView)paramView.findViewById(2131435357));
                ((ItemHolder)localObject2).d().b = ((MessageProgressTextView)paramView.findViewById(2131435380));
                ((ItemHolder)localObject2).d().c = ((ProgressBar)paramView.findViewById(2131444365));
                ((ItemHolder)localObject2).d().e = ((LinearLayout)paramView.findViewById(2131446328));
                ((ItemHolder)localObject2).d().f = ((TextView)paramView.findViewById(2131430775));
                ((ItemHolder)localObject2).d().g = ((TextView)paramView.findViewById(2131448957));
                if (!((DataLineMsgSet)localObject3).isSendFromLocal())
                {
                  ((ItemHolder)localObject2).d().j = ((TextView)paramView.findViewById(2131448956));
                  ((ItemHolder)localObject2).d().i = ((URLImageView)paramView.findViewById(2131435261));
                  ((ItemHolder)localObject2).d().h = ((LinearLayout)paramView.findViewById(2131446180));
                }
                if (((DataLineMsgSet)localObject3).isSendFromLocal())
                {
                  ((ItemHolder)localObject2).d().c.setVisibility(8);
                  ((ItemHolder)localObject2).d().b.setVisibility(0);
                  a((ItemHolder)localObject2, this.j, this.k);
                }
                else
                {
                  ((ItemHolder)localObject2).d().c.setVisibility(0);
                  ((ItemHolder)localObject2).d().b.setVisibility(8);
                }
                ((ItemHolder)localObject2).d().a.setAsyncClipSize(this.j, this.k);
                ((ItemHolder)localObject2).d().a.setDefaultImageByMargin();
                if (!BaseBubbleBuilder.m)
                {
                  ((ItemHolder)localObject2).d().a.setAdjustViewBounds(true);
                }
                else
                {
                  localObject1 = new AIOSendMask(2130706432, this.c.y() * 12.0F);
                  ((ItemHolder)localObject2).d().b.setBackgroundDrawable((Drawable)localObject1);
                  i1 = (int)TypedValue.applyDimension(2, 15.0F, this.b.getResources().getDisplayMetrics());
                  ((ItemHolder)localObject2).d().b.setDisplayInTextView(false, i1, -1);
                }
                ((ItemHolder)localObject2).d().a.setIsDrawRound(true);
                ((ItemHolder)localObject2).d().d.setContentDescription(HardCodeUtil.a(2131900898));
                ((ItemHolder)localObject2).d().a.setContentDescription(HardCodeUtil.a(2131900906));
                break;
              case 0: 
              case 7: 
                localObject1 = (RelativeLayout)this.a.inflate(2131624667, null);
                ((ItemHolder)localObject2).b.addView((View)localObject1);
                ((ItemHolder)localObject2).f().b = ((RelativeLayout)localObject1);
                ((ItemHolder)localObject2).f().a = ((TextView)paramView.findViewById(2131447062));
                ((ItemHolder)localObject2).f().b.setAddStatesFromChildren(true);
                ((ItemHolder)localObject2).f().a.setTag(localObject2);
                ((ItemHolder)localObject2).f().a.setOnClickListener(this.e);
                ((ItemHolder)localObject2).f().a.setClickable(true);
                ((ItemHolder)localObject2).f().a.setOnLongClickListener(this.c.R);
                ((ItemHolder)localObject2).f().a.setOnTouchListener(this.c.S);
                ((ItemHolder)localObject2).f().a.setLongClickable(true);
                ((ItemHolder)localObject2).f().a.setMovementMethod(LinkMovementMethod.getInstance());
                ((ItemHolder)localObject2).f().a.setSpannableFactory(QQText.SPANNABLE_FACTORY);
                if (((DataLineMsgSet)localObject3).isSendFromLocal()) {
                  localObject1 = this.b.getResources().getColorStateList(2131168020);
                } else {
                  localObject1 = this.b.getResources().getColorStateList(2131168016);
                }
                ((ItemHolder)localObject2).f().a.setTextColor((ColorStateList)localObject1);
                ((ItemHolder)localObject2).a((ProgressBar)paramView.findViewById(2131445638));
                if (((ItemHolder)localObject2).l() != null) {
                  ((ItemHolder)localObject2).l().setVisibility(8);
                }
                break;
              }
              ((ItemHolder)localObject2).a((ImageView)paramView.findViewById(2131432586));
              ((ItemHolder)localObject2).a((TextView)paramView.findViewById(2131431625));
            }
          }
        }
        paramView.setTag(localObject2);
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = (ItemHolder)paramView.getTag();
      }
      ((ItemHolder)localObject1).a((DataLineMsgSet)localObject3);
      if (n != 12) {
        if (n == 14)
        {
          if (ThemeUtil.isInNightMode(this.d))
          {
            localObject2 = (ChatBackgroundDrawable)this.c.b.getTag(2131427358);
            if (localObject2 != null)
            {
              n = ChatBackground.a(((ChatBackgroundDrawable)localObject2).getBitmap());
              ((ItemHolder)localObject1).g().a.setTextColor(ColorStateList.valueOf(n));
            }
          }
        }
        else if (n == 15)
        {
          localObject1 = ((ItemHolder)localObject1).h();
          localObject2 = FileManagerUtil.a(localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_tips"), localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_link"), new DatalineSessionAdapter.4(this, localDataLineMsgRecord));
          ((ItemHolder.TipHolder)localObject1).a.setText((CharSequence)localObject2);
          ((ItemHolder.TipHolder)localObject1).a.setMovementMethod(LinkMovementMethod.getInstance());
          ((ItemHolder.TipHolder)localObject1).a.setHighlightColor(17170445);
        }
        else
        {
          if (n == 16)
          {
            localObject2 = ((ItemHolder)localObject1).h();
            if ((localDataLineMsgRecord != null) && (!TextUtils.isEmpty(localDataLineMsgRecord.msg)) && (((ItemHolder.TipHolder)localObject2).a != null) && (localDataLineMsgRecord.msg.indexOf(HardCodeUtil.a(2131900901)) >= 0))
            {
              localObject1 = FileManagerUtil.a(localDataLineMsgRecord.msg, HardCodeUtil.a(2131900889), new DatalineSessionAdapter.5(this, localDataLineMsgRecord));
              ((ItemHolder.TipHolder)localObject2).a.setText((CharSequence)localObject1);
              ((ItemHolder.TipHolder)localObject2).a.setMovementMethod(LinkMovementMethod.getInstance());
              ((ItemHolder.TipHolder)localObject2).a.setHighlightColor(17170445);
              break label3897;
            }
          }
          switch (n)
          {
          case 4: 
          default: 
            break;
          case 6: 
            c((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
            break;
          case 5: 
            b((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
            break;
          case 3: 
          case 10: 
            a((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
            break;
          case 2: 
          case 9: 
            e((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
            break;
          case 1: 
          case 8: 
            d((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
            break;
          case 0: 
          case 7: 
            ((ItemHolder)localObject1).f().c = localDataLineMsgRecord.msg;
            ((ItemHolder)localObject1).f().d = localDataLineMsgRecord.sessionid;
            localObject2 = ((ItemHolder)localObject1).f().a;
            localObject4 = AppConstants.DATALINE_PC_UIN;
            localObject4 = new QQText(localDataLineMsgRecord.msg, 13, 32, 6000);
            ((QQText)localObject4).setBizSrc("biz_src_jc_aio");
            ((TextView)localObject2).setText((CharSequence)localObject4);
            ((TextView)localObject2).setVisibility(0);
            if (((ItemHolder)localObject1).l() != null) {
              if ((localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.progress != 1.0F)) {
                ((ItemHolder)localObject1).l().setVisibility(0);
              } else {
                ((ItemHolder)localObject1).l().setVisibility(8);
              }
            }
            ((TextView)localObject2).setTextSize(0, ChatTextSizeSettingActivity.a(this.b.getApplicationContext()));
          }
          if (a(n))
          {
            b(n, (ItemHolder)localObject1, (DataLineMsgSet)localObject3);
          }
          else
          {
            a(localDataLineMsgRecord, ((ItemHolder)localObject1).b, (ItemHolder)localObject1);
            if (ThemeUtil.isDefaultTheme())
            {
              n = ((ItemHolder)localObject1).b.getPaddingLeft();
              i1 = ((ItemHolder)localObject1).b.getPaddingRight();
              int i2 = ((ItemHolder)localObject1).b.getPaddingTop();
              int i3 = ((ItemHolder)localObject1).b.getPaddingBottom();
              if (!((DataLineMsgSet)localObject3).isSendFromLocal()) {
                ((ItemHolder)localObject1).b.setPadding(n + (int)(this.c.y() * 2.0F), i2, i1, i3);
              } else {
                ((ItemHolder)localObject1).b.setPadding(n, i2, i1 + (int)(this.c.y() * 2.0F), i3);
              }
            }
            if (ThemeUtil.isInNightMode(this.d))
            {
              localObject2 = (ChatBackgroundDrawable)this.c.b.getTag(2131427358);
              if (localObject2 != null)
              {
                n = ChatBackground.a(((ChatBackgroundDrawable)localObject2).getBitmap());
                ((ItemHolder)localObject1).j().setTextColor(ColorStateList.valueOf(n));
              }
            }
            if (a(((DataLineMsgSet)localObject3).getMsgId()))
            {
              localObject2 = TimeFormatterUtils.a(this.b, 3, ((DataLineMsgSet)localObject3).getTime() * 1000L);
              ((ItemHolder)localObject1).j().setVisibility(0);
              ((ItemHolder)localObject1).j().setText((CharSequence)localObject2);
            }
            else
            {
              ((ItemHolder)localObject1).j().setVisibility(8);
            }
            f((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
          }
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 17;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    e();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineSessionAdapter", 2, " notifyDataSetChanged ---------->");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter
 * JD-Core Version:    0.7.0.1
 */