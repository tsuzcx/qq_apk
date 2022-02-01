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
  private float jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  private long jdField_a_of_type_Long;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new CommonHobbyForAIOShowItemBuilder.1(this);
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private View.OnClickListener b = new CommonHobbyForAIOShowItemBuilder.2(this);
  
  public CommonHobbyForAIOShowItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  @NonNull
  private Drawable a(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165886));
    float f = this.jdField_a_of_type_Float * 8.0F;
    localGradientDrawable.setCornerRadius(f);
    localGradientDrawable.setShape(0);
    int i = AIOUtils.b(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localGradientDrawable.setSize(i, i);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localGradientDrawable;
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    String str = null;
    try
    {
      paramString = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramString), localURLDrawableOptions);
      str = paramString;
      paramString.setTag(URLDrawableDecodeHandler.b(i, i, (int)f));
      str = paramString;
      paramString.setDecodeHandler(URLDrawableDecodeHandler.c);
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
      paramImageView2.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(paramLong)));
    }
    else
    {
      localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(paramLong));
      paramImageView1.setImageDrawable((Drawable)localObject);
      paramImageView2.setImageDrawable(localFaceDrawable);
    }
    boolean bool = SimpleUIUtil.a();
    if (paramBoolean)
    {
      if (bool) {
        paramInt = 2130844962;
      } else {
        paramInt = 2130844961;
      }
      paramImageView1.setBackgroundResource(paramInt);
      paramImageView2.setBackgroundResource(paramInt);
      return;
    }
    if (bool) {
      paramInt = 2130844960;
    } else {
      paramInt = 2130844959;
    }
    paramImageView1.setBackgroundResource(paramInt);
    paramImageView2.setBackgroundResource(paramInt);
  }
  
  private void a(View paramView, String paramString)
  {
    Object localObject2 = new JSONObject(paramString);
    int i = ((JSONObject)localObject2).optInt("type");
    String str1 = ((JSONObject)localObject2).optString("icon_url");
    paramString = ((JSONObject)localObject2).optString("jump_url");
    Object localObject1 = ((JSONObject)localObject2).optString("name");
    String str2 = ((JSONObject)localObject2).optString("sub_title");
    Object localObject3 = ((JSONObject)localObject2).optString("title");
    ((JSONObject)localObject2).optString("url");
    long l = ((JSONObject)localObject2).optLong("friend_uin");
    int j = ((JSONObject)localObject2).optInt("show_both_head");
    Object localObject4 = paramView.findViewById(2131369800);
    ((View)localObject4).getLayoutParams().width = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    Object localObject5 = (ImageView)((View)localObject4).findViewById(2131368731);
    ImageView localImageView = (ImageView)((View)localObject4).findViewById(2131368732);
    ((TextView)((View)localObject4).findViewById(2131380067)).setText((CharSequence)localObject3);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    a(l, j, (ImageView)localObject5, localImageView, bool);
    if ((i != 1) && (i != 500) && (i != 400) && (i != 401) && (i != 404) && (i != 402) && (i != 403))
    {
      if ((i != 100) && (i != 200) && (i != 300) && (i != 201))
      {
        ((TextView)((ViewStub)paramView.findViewById(2131380914)).inflate().findViewById(2131380064)).setText(HardCodeUtil.a(2131702407));
        return;
      }
      paramView = ((ViewStub)paramView.findViewById(2131380913)).inflate();
      localObject3 = (URLImageView)paramView.findViewById(2131368733);
      localObject4 = (TextView)paramView.findViewById(2131380066);
      localObject5 = (TextView)paramView.findViewById(2131380065);
      ((TextView)localObject4).setText((CharSequence)localObject1);
      if (TextUtils.isEmpty(str2)) {
        ((TextView)localObject5).setVisibility(8);
      } else {
        ((TextView)localObject5).setText(str2);
      }
      ((URLImageView)localObject3).setImageDrawable(a(str1));
      if (i == 100)
      {
        localObject1 = (ImageView)paramView.findViewById(2131368736);
        ((ImageView)localObject1).setVisibility(0);
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
        ((URLImageView)localObject3).setTag(localObject2);
        ((ImageView)localObject1).setTag(localObject2);
        ((URLImageView)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ImageView)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      else if ((i == 201) || (i == 200))
      {
        paramView.setOnClickListener(this.b);
      }
      paramView.setTag(paramString);
      a(bool, (TextView)localObject4);
      return;
    }
    paramView = ((ViewStub)paramView.findViewById(2131380914)).inflate();
    localObject2 = (TextView)paramView.findViewById(2131380064);
    ((TextView)localObject2).setText((CharSequence)localObject1);
    paramView.setTag(paramString);
    paramView.setOnClickListener(this.b);
    a(bool, (TextView)localObject2);
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private void a(boolean paramBoolean, TextView paramTextView)
  {
    if (!paramBoolean)
    {
      paramTextView.setTextColor(-14277082);
      return;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167063));
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561011, null);
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
    this.jdField_a_of_type_Long = paramMessageRecord.uniseq;
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
    return QQPlayerService.a(1, String.valueOf(this.jdField_a_of_type_Long));
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null) {
        return;
      }
      Resources localResources = ((ImageView)localObject).getContext().getResources();
      if ((paramInt != 2) && (paramInt != 1))
      {
        ((ImageView)localObject).post(new CommonHobbyForAIOShowItemBuilder.4(this, (ImageView)localObject));
        ((ImageView)localObject).setContentDescription(localResources.getString(2131690211));
        return;
      }
      ((ImageView)localObject).post(new CommonHobbyForAIOShowItemBuilder.3(this, (ImageView)localObject));
      ((ImageView)localObject).setContentDescription(localResources.getString(2131690213));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder
 * JD-Core Version:    0.7.0.1
 */