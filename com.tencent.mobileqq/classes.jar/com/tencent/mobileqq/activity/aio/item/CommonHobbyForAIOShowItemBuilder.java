package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;
import uvi;
import uvj;
import uvk;
import uvl;

public class CommonHobbyForAIOShowItemBuilder
  extends AbstractChatItemBuilder
  implements QQPlayerService.QQPlayerCallback
{
  private float jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  private long jdField_a_of_type_Long;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new uvi(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private View.OnClickListener b = new uvj(this);
  
  public CommonHobbyForAIOShowItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void a(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CommonHobbyForAIOShowItemBuilder", 0, "bindData2View msg is: " + paramString);
    }
    JSONObject localJSONObject;
    int i;
    String str;
    Object localObject1;
    Object localObject5;
    int j;
    boolean bool;
    for (;;)
    {
      long l;
      try
      {
        localJSONObject = new JSONObject(paramString);
        i = localJSONObject.optInt("type");
        paramString = localJSONObject.optString("icon_url");
        str = localJSONObject.optString("jump_url");
        localObject1 = localJSONObject.optString("name");
        localObject5 = localJSONObject.optString("sub_title");
        localObject4 = localJSONObject.optString("title");
        localJSONObject.optString("url");
        l = localJSONObject.optLong("friend_uin");
        j = localJSONObject.optInt("show_both_head");
        localObject6 = paramView.findViewById(2131364935);
        ((View)localObject6).getLayoutParams().width = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        localObject2 = (ImageView)((View)localObject6).findViewById(2131369941);
        localObject3 = (ImageView)((View)localObject6).findViewById(2131369942);
        ((TextView)((View)localObject6).findViewById(2131369943)).setText((CharSequence)localObject4);
        bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
        if (j == 1) {
          break label363;
        }
        ((ImageView)localObject2).setVisibility(8);
        localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject4).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject4).addRule(14);
        ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((ImageView)localObject3).setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(l)));
        if (!bool) {
          break label412;
        }
        ((ImageView)localObject2).setBackgroundResource(2130842373);
        ((ImageView)localObject3).setBackgroundResource(2130842373);
      }
      catch (JSONException paramView) {}
      paramView = ((ViewStub)paramView.findViewById(2131369945)).inflate();
      paramString = (TextView)paramView.findViewById(2131363810);
      paramString.setText((CharSequence)localObject1);
      paramView.setTag(str);
      paramView.setOnClickListener(this.b);
      if (bool) {
        break label429;
      }
      paramString.setTextColor(-14277082);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CommonHobbyForAIOShowItemBuilder", 0, Log.getStackTraceString(paramView));
      return;
      label363:
      localObject4 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      Object localObject6 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(l));
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject4);
      ((ImageView)localObject3).setImageDrawable((Drawable)localObject6);
    }
    label412:
    ((ImageView)localObject2).setBackgroundResource(2130842372);
    ((ImageView)localObject3).setBackgroundResource(2130842372);
    break label862;
    label429:
    paramString.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494219));
    return;
    label446:
    Object localObject2 = ((ViewStub)paramView.findViewById(2131369944)).inflate();
    Object localObject3 = (URLImageView)((View)localObject2).findViewById(2131369702);
    Object localObject4 = (TextView)((View)localObject2).findViewById(2131369938);
    paramView = (TextView)((View)localObject2).findViewById(2131369939);
    ((TextView)localObject4).setText((CharSequence)localObject1);
    label516:
    float f;
    if (TextUtils.isEmpty((CharSequence)localObject5))
    {
      paramView.setVisibility(8);
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493213));
      f = 8.0F * this.jdField_a_of_type_Float;
      ((GradientDrawable)localObject1).setCornerRadius(f);
      ((GradientDrawable)localObject1).setShape(0);
      j = AIOUtils.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((GradientDrawable)localObject1).setSize(j, j);
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = j;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = j;
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable;
      paramView = null;
    }
    label817:
    label953:
    for (;;)
    {
      try
      {
        paramString = URLDrawable.getDrawable(NearbyImgDownloader.a(paramString), (URLDrawable.URLDrawableOptions)localObject5);
        paramView = paramString;
        paramString.setTag(URLDrawableDecodeHandler.a(j, j, (int)f));
        paramView = paramString;
        paramString.setDecodeHandler(URLDrawableDecodeHandler.b);
        paramView = paramString;
        paramString = paramView;
        if (paramView == null) {
          paramString = (String)localObject1;
        }
        ((URLImageView)localObject3).setImageDrawable(paramString);
        if (i == 100)
        {
          paramView = (ImageView)((View)localObject2).findViewById(2131369937);
          paramView.setVisibility(0);
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
          ((URLImageView)localObject3).setTag(localJSONObject);
          paramView.setTag(localJSONObject);
          ((URLImageView)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        ((View)localObject2).setTag(str);
        if ((i == 201) || (i == 200)) {
          ((View)localObject2).setOnClickListener(this.b);
        }
        if (bool) {
          break label817;
        }
        ((TextView)localObject4).setTextColor(-14277082);
        return;
      }
      catch (MalformedURLException paramString)
      {
        if (!QLog.isColorLevel()) {
          break label953;
        }
      }
      paramView.setText((CharSequence)localObject5);
      break label516;
      QLog.i("CommonHobbyForAIOShowItemBuilder", 0, Log.getStackTraceString(paramString));
      break label953;
      ((TextView)localObject4).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494219));
      return;
      label862:
      do
      {
        ((TextView)((ViewStub)paramView.findViewById(2131369945)).inflate().findViewById(2131363810)).setText("快来认识一下有趣的他吧！");
        return;
        if ((i == 1) || (i == 500) || (i == 400) || (i == 401) || (i == 404) || (i == 402) || (i == 403)) {
          break;
        }
        if ((i == 100) || (i == 200) || (i == 300)) {
          break label446;
        }
      } while (i != 201);
      break label446;
    }
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970283, null);
      a(paramViewHolder, paramMessageRecord.msg);
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
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localImageView == null);
    Resources localResources = localImageView.getContext().getResources();
    if ((paramInt == 2) || (paramInt == 1))
    {
      localImageView.post(new uvk(this, localImageView));
      localImageView.setContentDescription(localResources.getString(2131437019));
      return;
    }
    localImageView.post(new uvl(this, localImageView));
    localImageView.setContentDescription(localResources.getString(2131437018));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder
 * JD-Core Version:    0.7.0.1
 */