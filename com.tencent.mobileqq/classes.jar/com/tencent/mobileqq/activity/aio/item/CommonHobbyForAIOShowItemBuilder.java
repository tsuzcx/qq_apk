package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.music.QQPlayerCallback;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonHobbyForAIOShowItemBuilder
  extends AbstractChatItemBuilder
  implements QQPlayerCallback
{
  private WeakReference<ImageView> e;
  private float f = this.c.getResources().getDisplayMetrics().density;
  private long g;
  private View.OnClickListener h = new CommonHobbyForAIOShowItemBuilder.1(this);
  private View.OnClickListener i = new CommonHobbyForAIOShowItemBuilder.2(this);
  
  public CommonHobbyForAIOShowItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  @NonNull
  private Drawable a(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(this.c.getResources().getColor(2131166580));
    float f1 = this.f * 8.0F;
    localGradientDrawable.setCornerRadius(f1);
    localGradientDrawable.setShape(0);
    int j = AIOUtils.b(35.0F, this.c.getResources());
    localGradientDrawable.setSize(j, j);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = j;
    localURLDrawableOptions.mRequestHeight = j;
    localURLDrawableOptions.mFailedDrawable = localGradientDrawable;
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    String str = null;
    try
    {
      paramString = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramString), localURLDrawableOptions);
      str = paramString;
      paramString.setTag(URLDrawableDecodeHandler.b(j, j, (int)f1));
      str = paramString;
      paramString.setDecodeHandler(URLDrawableDecodeHandler.d);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      paramString = str;
      if (QLog.isColorLevel())
      {
        QLog.i("CommonHobbyForAIOShowItemBuilder", 0, Log.getStackTraceString(localMalformedURLException));
        paramString = str;
      }
    }
    if (paramString == null) {
      return localGradientDrawable;
    }
    return paramString;
  }
  
  private void a(long paramLong, int paramInt, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt != 1)
    {
      paramImageView1.setVisibility(8);
      localObject = (RelativeLayout.LayoutParams)paramImageView2.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramImageView2.setImageDrawable(FaceDrawable.getFaceDrawable(this.a, 1, String.valueOf(paramLong)));
    }
    else
    {
      localObject = FaceDrawable.getFaceDrawable(this.a, 1, this.a.getCurrentUin());
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.a, 1, String.valueOf(paramLong));
      paramImageView1.setImageDrawable((Drawable)localObject);
      paramImageView2.setImageDrawable(localFaceDrawable);
    }
    boolean bool = SimpleUIUtil.e();
    if (paramBoolean)
    {
      if (bool) {
        paramInt = 2130846398;
      } else {
        paramInt = 2130846397;
      }
      paramImageView1.setBackgroundResource(paramInt);
      paramImageView2.setBackgroundResource(paramInt);
      return;
    }
    if (bool) {
      paramInt = 2130846396;
    } else {
      paramInt = 2130846395;
    }
    paramImageView1.setBackgroundResource(paramInt);
    paramImageView2.setBackgroundResource(paramInt);
  }
  
  private void a(View paramView, String paramString)
  {
    Object localObject2 = new JSONObject(paramString);
    int j = ((JSONObject)localObject2).optInt("type");
    String str1 = ((JSONObject)localObject2).optString("icon_url");
    paramString = ((JSONObject)localObject2).optString("jump_url");
    Object localObject1 = ((JSONObject)localObject2).optString("name");
    String str2 = ((JSONObject)localObject2).optString("sub_title");
    Object localObject3 = ((JSONObject)localObject2).optString("title");
    ((JSONObject)localObject2).optString("url");
    long l = ((JSONObject)localObject2).optLong("friend_uin");
    int k = ((JSONObject)localObject2).optInt("show_both_head");
    Object localObject4 = paramView.findViewById(2131436932);
    ((View)localObject4).getLayoutParams().width = this.c.getResources().getDisplayMetrics().widthPixels;
    Object localObject5 = (ImageView)((View)localObject4).findViewById(2131435644);
    ImageView localImageView = (ImageView)((View)localObject4).findViewById(2131435645);
    ((TextView)((View)localObject4).findViewById(2131448980)).setText((CharSequence)localObject3);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    a(l, k, (ImageView)localObject5, localImageView, bool);
    if ((j != 1) && (j != 500) && (j != 400) && (j != 401) && (j != 404) && (j != 402) && (j != 403))
    {
      if ((j != 100) && (j != 200) && (j != 300) && (j != 201))
      {
        ((TextView)((ViewStub)paramView.findViewById(2131449903)).inflate().findViewById(2131448977)).setText(HardCodeUtil.a(2131900410));
        return;
      }
      paramView = ((ViewStub)paramView.findViewById(2131449902)).inflate();
      localObject3 = (URLImageView)paramView.findViewById(2131435646);
      localObject4 = (TextView)paramView.findViewById(2131448979);
      localObject5 = (TextView)paramView.findViewById(2131448978);
      ((TextView)localObject4).setText((CharSequence)localObject1);
      if (TextUtils.isEmpty(str2)) {
        ((TextView)localObject5).setVisibility(8);
      } else {
        ((TextView)localObject5).setText(str2);
      }
      ((URLImageView)localObject3).setImageDrawable(a(str1));
      if (j == 100)
      {
        localObject1 = (ImageView)paramView.findViewById(2131435649);
        ((ImageView)localObject1).setVisibility(0);
        this.e = new WeakReference(localObject1);
        ((URLImageView)localObject3).setTag(localObject2);
        ((ImageView)localObject1).setTag(localObject2);
        ((URLImageView)localObject3).setOnClickListener(this.h);
        ((ImageView)localObject1).setOnClickListener(this.h);
      }
      else if ((j == 201) || (j == 200))
      {
        paramView.setOnClickListener(this.i);
      }
      paramView.setTag(paramString);
      a(bool, (TextView)localObject4);
      return;
    }
    paramView = ((ViewStub)paramView.findViewById(2131449903)).inflate();
    localObject2 = (TextView)paramView.findViewById(2131448977);
    ((TextView)localObject2).setText((CharSequence)localObject1);
    paramView.setTag(paramString);
    paramView.setOnClickListener(this.i);
    a(bool, (TextView)localObject2);
  }
  
  private void a(boolean paramBoolean, TextView paramTextView)
  {
    if (!paramBoolean)
    {
      paramTextView.setTextColor(-14277082);
      return;
    }
    paramTextView.setTextColor(this.c.getResources().getColor(2131168001));
  }
  
  private void b(String paramString)
  {
    Intent localIntent = new Intent(this.c, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    this.c.startActivity(localIntent);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.c).inflate(2131627352, null);
      if (QLog.isColorLevel()) {
        QLog.i("CommonHobbyForAIOShowItemBuilder", 0, String.format("bindData2View msg is: %s", new Object[] { paramMessageRecord.msg }));
      }
      try
      {
        a(paramViewHolder, paramMessageRecord.msg);
      }
      catch (Exception paramView)
      {
        QLog.e("CommonHobbyForAIOShowItemBuilder", 1, "getItemView Exception", paramView);
      }
      catch (JSONException paramView)
      {
        QLog.e("CommonHobbyForAIOShowItemBuilder", 1, "getItemView JSONException", paramView);
      }
    }
    this.g = paramMessageRecord.uniseq;
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new CommonHobbyForAIOShowItemBuilder.CommonHobbyForAIOShowViewHolder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public String getToken()
  {
    return QQPlayerService.a(1, String.valueOf(this.g));
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (ImageView)this.e.get();
      if (localObject == null) {
        return;
      }
      Resources localResources = ((ImageView)localObject).getContext().getResources();
      if ((paramInt != 2) && (paramInt != 1))
      {
        ((ImageView)localObject).post(new CommonHobbyForAIOShowItemBuilder.4(this, (ImageView)localObject));
        ((ImageView)localObject).setContentDescription(localResources.getString(2131887111));
        return;
      }
      ((ImageView)localObject).post(new CommonHobbyForAIOShowItemBuilder.3(this, (ImageView)localObject));
      ((ImageView)localObject).setContentDescription(localResources.getString(2131887113));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder
 * JD-Core Version:    0.7.0.1
 */