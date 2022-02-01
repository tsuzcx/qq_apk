package com.dataline.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XPanelContainer;

public class DatalineSessionAdapterUseNewFileBubble
  extends DatalineSessionAdapter
{
  private View.OnClickListener f = new DatalineSessionAdapterUseNewFileBubble.1(this);
  private View.OnClickListener h = new DatalineSessionAdapterUseNewFileBubble.2(this);
  
  public DatalineSessionAdapterUseNewFileBubble(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramDataLineMsgSetList, paramLiteActivity, paramQQAppInterface);
  }
  
  private void a(View paramView, ItemHolder paramItemHolder)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131439884);
    ImageView localImageView = new ImageView(this.b);
    localImageView.setImageResource(2130838287);
    localImageView.setId(2131430598);
    paramItemHolder.i().j = localImageView;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramView.addView(localImageView, localLayoutParams);
    localImageView.setVisibility(8);
    localImageView.setContentDescription(this.b.getString(2131889250));
    localImageView = new ImageView(this.b);
    localImageView.setImageResource(2130838271);
    localImageView.setId(2131430584);
    paramItemHolder.i().k = localImageView;
    paramItemHolder = new RelativeLayout.LayoutParams(-2, -2);
    paramItemHolder.addRule(13);
    paramView.addView(localImageView, paramItemHolder);
    localImageView.setVisibility(8);
    localImageView.setContentDescription(this.b.getString(2131889805));
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, ItemHolder paramItemHolder)
  {
    boolean bool = paramDataLineMsgRecord.isSendFromLocal();
    String str = "";
    if (bool)
    {
      if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc))
      {
        paramDataLineMsgRecord = new StringBuilder();
        paramDataLineMsgRecord.append(" / ");
        paramDataLineMsgRecord.append(this.b.getString(2131889345));
        str = paramDataLineMsgRecord.toString();
      }
      else if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        paramDataLineMsgRecord = new StringBuilder();
        paramDataLineMsgRecord.append(" / ");
        paramDataLineMsgRecord.append(this.b.getString(2131891328));
        str = paramDataLineMsgRecord.toString();
      }
      else if ((!paramDataLineMsgRecord.bIsTransfering) && (!paramDataLineMsgRecord.issuc))
      {
        if ((!paramDataLineMsgRecord.bIsSended) && (paramDataLineMsgRecord.nOpType != 1))
        {
          paramDataLineMsgRecord = new StringBuilder();
          paramDataLineMsgRecord.append(" / ");
          paramDataLineMsgRecord.append(this.b.getString(2131889344));
          str = paramDataLineMsgRecord.toString();
        }
        else
        {
          paramDataLineMsgRecord = new StringBuilder();
          paramDataLineMsgRecord.append(" / ");
          paramDataLineMsgRecord.append(this.b.getString(2131889343));
          str = paramDataLineMsgRecord.toString();
        }
      }
    }
    else if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc))
    {
      paramDataLineMsgRecord = new StringBuilder();
      paramDataLineMsgRecord.append(" / ");
      paramDataLineMsgRecord.append(this.b.getString(2131889337));
      str = paramDataLineMsgRecord.toString();
    }
    else if (paramDataLineMsgRecord.fileMsgStatus == 2L)
    {
      paramDataLineMsgRecord = new StringBuilder();
      paramDataLineMsgRecord.append(" / ");
      paramDataLineMsgRecord.append(this.b.getString(2131891328));
      str = paramDataLineMsgRecord.toString();
    }
    else if ((!paramDataLineMsgRecord.bIsTransfering) && (!paramDataLineMsgRecord.issuc))
    {
      paramDataLineMsgRecord = new StringBuilder();
      paramDataLineMsgRecord.append(" / ");
      paramDataLineMsgRecord.append(this.b.getString(2131889343));
      str = paramDataLineMsgRecord.toString();
    }
    if (!TextUtils.isEmpty(str))
    {
      paramItemHolder.i().f.setVisibility(0);
      paramItemHolder.i().f.setText(str);
      return;
    }
    paramItemHolder.i().f.setVisibility(8);
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet, ItemHolder paramItemHolder)
  {
    int i;
    if (paramDataLineMsgSet.isSendFromLocal()) {
      i = 2130852132;
    } else {
      i = 2130851950;
    }
    paramItemHolder.b.setBackgroundResource(i);
  }
  
  private boolean a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) && (FileUtil.d(paramDataLineMsgRecord.path));
  }
  
  private void b(View paramView, ItemHolder paramItemHolder)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131439884);
    CircleFileStateView localCircleFileStateView = new CircleFileStateView(this.b);
    localCircleFileStateView.setId(2131430582);
    localCircleFileStateView.setProgressRingWidth(0.0F);
    localCircleFileStateView.setCenterBgColor(-1);
    localCircleFileStateView.setState(2);
    paramItemHolder.i().b = localCircleFileStateView;
    int i = AIOUtils.b(24.0F, this.b.getResources());
    paramView.addView(localCircleFileStateView, new RelativeLayout.LayoutParams(i, i));
    localCircleFileStateView.setVisibility(4);
    localCircleFileStateView.setContentDescription(this.b.getString(2131889338));
    localCircleFileStateView = new CircleFileStateView(this.b);
    localCircleFileStateView.setId(2131430583);
    localCircleFileStateView.setProgressRingWidth(0.0F);
    localCircleFileStateView.setCenterBgColor(-1);
    localCircleFileStateView.setState(1);
    paramItemHolder.i().c = localCircleFileStateView;
    paramView.addView(localCircleFileStateView, new RelativeLayout.LayoutParams(i, i));
    localCircleFileStateView.setVisibility(4);
    localCircleFileStateView.setContentDescription(this.b.getString(2131889596));
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord, ItemHolder paramItemHolder)
  {
    if ((paramDataLineMsgRecord.progress != 1.0F) && (paramDataLineMsgRecord.issuc) && (paramDataLineMsgRecord.fileMsgStatus != 1L) && (paramDataLineMsgRecord.fileMsgStatus != 2L))
    {
      i = (int)(paramDataLineMsgRecord.progress * 100.0F);
      paramItemHolder.i().g.setVisibility(0);
      paramItemHolder.i().g.setProgress(i);
      ProgressBar localProgressBar = paramItemHolder.i().g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.getString(2131889388));
      localStringBuilder.append(i);
      localProgressBar.setContentDescription(localStringBuilder.toString());
      i = AIOUtils.b(14.0F, this.b.getResources());
      j = AIOUtils.b(18.0F, this.b.getResources());
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramItemHolder.i().h.setPadding(i, i, j, 0);
        return;
      }
      paramItemHolder.i().h.setPadding(j, i, i, 0);
      return;
    }
    paramItemHolder.i().g.setVisibility(8);
    int i = AIOUtils.b(14.0F, this.b.getResources());
    int j = AIOUtils.b(18.0F, this.b.getResources());
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramItemHolder.i().h.setPadding(i, i, j, i);
      return;
    }
    paramItemHolder.i().h.setPadding(j, i, i, i);
  }
  
  private void c(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
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
    Object localObject = paramDataLineMsgSet.filename;
    long l = paramDataLineMsgSet.filesize;
    a(paramItemHolder.i().i, paramDataLineMsgSet);
    paramItemHolder.i().d.setText((CharSequence)localObject);
    paramItemHolder.i().e.setText(FileUtil.a(l, this.b.getResources().getDisplayMetrics().densityDpi));
    b(paramDataLineMsgSet, paramItemHolder);
    a(paramDataLineMsgSet, paramItemHolder);
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      localObject = paramItemHolder.i().j;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = paramItemHolder.i().k;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = paramItemHolder.i().b;
      if (localObject != null) {
        ((CircleFileStateView)localObject).setVisibility(8);
      }
      localObject = paramItemHolder.i().c;
      if (localObject != null) {
        ((CircleFileStateView)localObject).setVisibility(8);
      }
      if ((!paramDataLineMsgSet.bIsSended) && (paramDataLineMsgSet.nOpType != 1)) {
        c(paramDataLineMsgSet, paramItemHolder);
      } else {
        d(paramDataLineMsgSet, paramItemHolder);
      }
    }
    else
    {
      d(paramDataLineMsgSet, paramItemHolder);
    }
    e(paramDataLineMsgSet, paramItemHolder);
  }
  
  private void c(DataLineMsgRecord paramDataLineMsgRecord, ItemHolder paramItemHolder)
  {
    ImageView localImageView1 = paramItemHolder.i().j;
    ImageView localImageView2 = paramItemHolder.i().k;
    if (localImageView1 != null)
    {
      if (localImageView2 == null) {
        return;
      }
      if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc))
      {
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(8);
      }
      else if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(0);
      }
      else if (paramDataLineMsgRecord.bIsTransfering)
      {
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(8);
      }
      else if (!paramDataLineMsgRecord.issuc)
      {
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(0);
      }
      else
      {
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(8);
      }
      localImageView1.setTag(paramItemHolder);
      localImageView2.setTag(paramItemHolder);
      localImageView1.setOnClickListener(this.f);
      localImageView2.setOnClickListener(this.c.N);
    }
  }
  
  private void d(DataLineMsgRecord paramDataLineMsgRecord, ItemHolder paramItemHolder)
  {
    CircleFileStateView localCircleFileStateView1 = paramItemHolder.i().b;
    CircleFileStateView localCircleFileStateView2 = paramItemHolder.i().c;
    if (localCircleFileStateView1 != null)
    {
      if (localCircleFileStateView2 == null) {
        return;
      }
      if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc))
      {
        localCircleFileStateView1.setVisibility(8);
        localCircleFileStateView2.setVisibility(8);
      }
      else if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else if (paramDataLineMsgRecord.fileMsgStatus == 1L)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else if (paramDataLineMsgRecord.bIsTransfering)
      {
        localCircleFileStateView1.setVisibility(8);
        localCircleFileStateView2.setVisibility(0);
      }
      else if (!paramDataLineMsgRecord.issuc)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else
      {
        localCircleFileStateView1.setVisibility(8);
        localCircleFileStateView2.setVisibility(0);
      }
      localCircleFileStateView1.setTag(paramItemHolder);
      localCircleFileStateView2.setTag(paramItemHolder);
      localCircleFileStateView1.setOnClickListener(this.c.O);
      localCircleFileStateView2.setOnClickListener(this.h);
    }
  }
  
  private void e(DataLineMsgRecord paramDataLineMsgRecord, ItemHolder paramItemHolder)
  {
    if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc) && (!a(paramDataLineMsgRecord)))
    {
      CircleFileStateView localCircleFileStateView1 = paramItemHolder.i().b;
      CircleFileStateView localCircleFileStateView2 = paramItemHolder.i().c;
      localCircleFileStateView1.setVisibility(0);
      localCircleFileStateView1.setState(2);
      localCircleFileStateView2.setVisibility(8);
      if (!paramDataLineMsgRecord.isSendFromLocal()) {
        paramItemHolder.i().f.setVisibility(8);
      }
      localCircleFileStateView1.setTag(paramItemHolder);
      localCircleFileStateView2.setTag(paramItemHolder);
      localCircleFileStateView1.setOnClickListener(this.c.O);
      localCircleFileStateView2.setOnClickListener(this.h);
    }
  }
  
  protected View a(int paramInt, ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramInt == 17)
    {
      localObject1 = this.a.inflate(2131624650, null);
      localObject3 = (ImageView)((View)localObject1).findViewById(2131435219);
      localObject2 = this.c.getResources().getDrawable(2130845599);
      i = DataLineMsgRecord.getDevTypeBySet(paramDataLineMsgSet);
      if (i == 0)
      {
        paramDataLineMsgSet = this.c.getResources().getDrawable(2130845599);
      }
      else
      {
        paramDataLineMsgSet = (DataLineMsgSet)localObject2;
        if (i == 1) {
          paramDataLineMsgSet = this.c.getResources().getDrawable(2130845594);
        }
      }
      ((ImageView)localObject3).setImageDrawable(paramDataLineMsgSet);
      paramDataLineMsgSet = (DataLineMsgSet)localObject1;
    }
    else
    {
      paramDataLineMsgSet = this.a.inflate(2131624651, null);
    }
    paramItemHolder.b = ((RelativeLayout)paramDataLineMsgSet.findViewById(2131438925));
    paramItemHolder.b.setTag(paramItemHolder);
    paramItemHolder.b.setClickable(true);
    paramItemHolder.b.setLongClickable(true);
    paramItemHolder.b.setOnClickListener(this.e);
    paramItemHolder.b.setOnLongClickListener(this.c.R);
    paramItemHolder.b.setOnTouchListener(this.c.S);
    paramItemHolder.b.setAddStatesFromChildren(true);
    paramItemHolder.a((TextView)paramDataLineMsgSet.findViewById(2131431625));
    int i = AIOUtils.b(14.0F, this.b.getResources());
    int j = AIOUtils.b(6.0F, this.b.getResources());
    Object localObject1 = new RelativeLayout(this.b);
    ((RelativeLayout)localObject1).setId(2131430578);
    Object localObject2 = this.b.getResources();
    ((RelativeLayout)localObject1).setPadding(((Resources)localObject2).getDimensionPixelSize(2131296611), ((Resources)localObject2).getDimensionPixelSize(2131296614), ((Resources)localObject2).getDimensionPixelSize(2131296609), ((Resources)localObject2).getDimensionPixelSize(2131296613));
    Object localObject3 = new RelativeLayout.LayoutParams(BaseChatItemLayout.z, -2);
    int k = ((Resources)localObject2).getDimensionPixelSize(2131299800);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(k, 0, k, 0);
    ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131435219);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject2 = new LinearLayout(this.b);
    ((LinearLayout)localObject2).setMinimumHeight(AIOUtils.b(76.0F, this.b.getResources()));
    ((LinearLayout)localObject2).setOrientation(1);
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(10, 2131430578);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new RelativeLayout(this.b);
    ((RelativeLayout)localObject3).setId(2131433128);
    Object localObject4 = new LinearLayout.LayoutParams(-1, -2);
    ((RelativeLayout)localObject3).setPadding(i, i, i, 0);
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    paramItemHolder.i().h = ((RelativeLayout)localObject3);
    k = AIOUtils.b(48.0F, this.b.getResources());
    localObject4 = new AsyncImageView(this.b);
    ((AsyncImageView)localObject4).setWidth(k);
    ((AsyncImageView)localObject4).setHeight(k);
    ((AsyncImageView)localObject4).setId(2131430545);
    ((AsyncImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
    paramItemHolder.i().i = ((AsyncImageView)localObject4);
    localObject4 = new EllipsizingTextView(this.b, null);
    ((TextView)localObject4).setId(2131430547);
    ((TextView)localObject4).setGravity(48);
    ((TextView)localObject4).setIncludeFontPadding(false);
    ((TextView)localObject4).setLineSpacing(0.0F, 1.0F);
    ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.MIDDLE);
    ((TextView)localObject4).setTextSize(1, 17.0F);
    ((TextView)localObject4).setMaxLines(2);
    ((TextView)localObject4).setTextColor(Color.parseColor("#03081a"));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(0, 2131430545);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(10);
    ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
    paramItemHolder.i().d = ((TextView)localObject4);
    localObject4 = new TextView(this.b);
    ((TextView)localObject4).setId(2131430544);
    ((TextView)localObject4).setSingleLine();
    if (VersionUtils.e()) {
      ((TextView)localObject4).setAlpha(0.75F);
    }
    ((TextView)localObject4).setGravity(17);
    ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject4).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(3, 2131430547);
    localLayoutParams.setMargins(0, j, 0, 0);
    ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
    paramItemHolder.i().e = ((TextView)localObject4);
    localObject4 = new TextView(this.b);
    ((TextView)localObject4).setId(2131430549);
    ((TextView)localObject4).setSingleLine();
    if (VersionUtils.e()) {
      ((TextView)localObject4).setAlpha(0.75F);
    }
    ((TextView)localObject4).setGravity(17);
    ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject4).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 2131430544);
    localLayoutParams.addRule(8, 2131430544);
    localLayoutParams.setMargins(0, j, 0, 0);
    ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
    paramItemHolder.i().f = ((TextView)localObject4);
    localObject3 = new ProgressBar(this.b, null, 16842872);
    ((ProgressBar)localObject3).setId(2131430548);
    ((ProgressBar)localObject3).setMax(100);
    ((ProgressBar)localObject3).setProgressDrawable(this.b.getResources().getDrawable(2130838011));
    localObject4 = new LinearLayout.LayoutParams(-1, AIOUtils.b(2.0F, this.b.getResources()));
    ((LinearLayout.LayoutParams)localObject4).setMargins(i, j, i, j);
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    paramItemHolder.i().g = ((ProgressBar)localObject3);
    paramItemHolder.i().a = ((View)localObject1);
    paramItemHolder.b.addView((View)localObject1);
    if (paramInt == 18)
    {
      a(paramDataLineMsgSet, paramItemHolder);
      b(paramDataLineMsgSet, paramItemHolder);
      return paramDataLineMsgSet;
    }
    b(paramDataLineMsgSet, paramItemHolder);
    return paramDataLineMsgSet;
  }
  
  protected void a(DataLineMsgRecord paramDataLineMsgRecord, View paramView, float paramFloat)
  {
    super.a(paramDataLineMsgRecord, paramView, paramFloat);
    if (paramDataLineMsgRecord != null)
    {
      if (paramView == null) {
        return;
      }
      float f1 = paramFloat;
      if (paramFloat < paramDataLineMsgRecord.progress) {
        f1 = paramDataLineMsgRecord.progress;
      }
      ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131430548);
      if (localProgressBar != null)
      {
        localProgressBar.setVisibility(0);
        localProgressBar.setProgress((int)(f1 * 100.0F));
      }
      paramView = (RelativeLayout)paramView.findViewById(2131433128);
      if (paramView != null)
      {
        int i = AIOUtils.b(14.0F, this.b.getResources());
        int j = AIOUtils.b(18.0F, this.b.getResources());
        if (paramDataLineMsgRecord.isSendFromLocal())
        {
          paramView.setPadding(i, i, j, 0);
          return;
        }
        paramView.setPadding(j, i, i, 0);
      }
    }
  }
  
  void a(AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str = FileUtil.a(paramDataLineMsgRecord.filename);
    if (TextUtils.isEmpty(str))
    {
      paramAsyncImageView.setImageResource(2130845755);
      return;
    }
    paramAsyncImageView.setDefaultImage(FileManagerUtil.i(str));
    if (FileManagerUtil.c(str) == 0)
    {
      str = paramDataLineMsgRecord.filename;
      if (FileUtils.fileExistsAndNotEmpty(paramDataLineMsgRecord.thumbPath)) {
        str = paramDataLineMsgRecord.thumbPath;
      } else if (FileUtils.fileExistsAndNotEmpty(paramDataLineMsgRecord.path)) {
        str = paramDataLineMsgRecord.path;
      }
      paramAsyncImageView.setAsyncImage(str);
      return;
    }
    int i = FileManagerUtil.i(str);
    if (i != 0) {
      paramAsyncImageView.setImageResource(i);
    }
  }
  
  protected boolean a(int paramInt)
  {
    return (paramInt == 17) || (paramInt == 18);
  }
  
  protected void b(int paramInt, ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    c(paramItemHolder, paramDataLineMsgSet);
    a(paramDataLineMsgSet, paramItemHolder);
    if (ThemeUtil.isInNightMode(this.d))
    {
      Object localObject = this.c.b.getTag(2131427358);
      if ((localObject != null) && ((localObject instanceof ChatBackgroundDrawable)))
      {
        localObject = (ChatBackgroundDrawable)localObject;
        if (localObject != null)
        {
          paramInt = ChatBackground.a(((ChatBackgroundDrawable)localObject).getBitmap());
          paramItemHolder.j().setTextColor(ColorStateList.valueOf(paramInt));
        }
      }
    }
    if (a(paramDataLineMsgSet.getMsgId()))
    {
      paramDataLineMsgSet = TimeFormatterUtils.a(this.b, 3, paramDataLineMsgSet.getTime() * 1000L);
      paramItemHolder.j().setVisibility(0);
      paramItemHolder.j().setText(paramDataLineMsgSet);
      return;
    }
    paramItemHolder.j().setVisibility(8);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = super.getItemViewType(paramInt);
    if (i == 10) {
      return 18;
    }
    paramInt = i;
    if (i == 3) {
      paramInt = 17;
    }
    return paramInt;
  }
  
  public int getViewTypeCount()
  {
    return super.getViewTypeCount() + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapterUseNewFileBubble
 * JD-Core Version:    0.7.0.1
 */