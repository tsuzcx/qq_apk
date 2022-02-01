import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class armo
  extends BaseAdapter
  implements View.OnClickListener
{
  public static int a;
  private float jdField_a_of_type_Float;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  public arms a;
  URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new armp(this);
  public SessionInfo a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public DoutuData a;
  public HashMap<String, String> a;
  public List<DoutuData> a;
  public MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private DoutuData jdField_b_of_type_ComTencentMobileqqDoutuDoutuData = new DoutuData("abababababababababababab", null);
  public List<DoutuData> b;
  private int c;
  private int d;
  private int e;
  private int f = -1;
  
  static
  {
    jdField_a_of_type_Int = 4;
  }
  
  public armo(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler, boolean paramBoolean, arms paramarms, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Arms = paramarms;
    if ((paramBoolean) && (this.jdField_a_of_type_Arms != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Arms.b))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((paramInt > 0) && (this.jdField_a_of_type_Boolean)) {
        jdField_a_of_type_Int = paramInt;
      }
      if (!this.jdField_a_of_type_Boolean) {
        jdField_a_of_type_Int = 9;
      }
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramInt = i;
      while (paramInt < jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_JavaUtilList.add(new DoutuData());
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = afur.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.c = afur.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.d = afur.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.e = afur.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public void a()
  {
    int k = 0;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("DoutuEmotionAdapter", 2, "[doutu]resetData");
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      i = k;
      if (this.jdField_b_of_type_JavaUtilList == null) {
        break;
      }
      i = k;
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break;
      }
      i = j;
      while ((i < jdField_a_of_type_Int) && (i < this.jdField_b_of_type_JavaUtilList.size()))
      {
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.get(i));
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    while (i < 9)
    {
      this.jdField_a_of_type_JavaUtilList.add(new DoutuData());
      i += 1;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
      if (this.jdField_b_of_type_JavaUtilList.size() < jdField_a_of_type_Int) {
        break label235;
      }
    }
    label235:
    for (int i = jdField_a_of_type_Int;; i = this.jdField_b_of_type_JavaUtilList.size())
    {
      this.f = i;
      this.jdField_b_of_type_JavaUtilList.add(this.f, this.jdField_b_of_type_ComTencentMobileqqDoutuDoutuData);
      this.jdField_a_of_type_JavaUtilList.add(this.f, this.jdField_b_of_type_ComTencentMobileqqDoutuDoutuData);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong != this.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoutuEmotionAdapter", 2, "removeLoading key:" + paramLong + ", timeKey:" + this.jdField_a_of_type_Long);
      }
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList != null))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_ComTencentMobileqqDoutuDoutuData);
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while ((i < j) && (i < this.jdField_b_of_type_JavaUtilList.size()))
      {
        localArrayList.add(this.jdField_b_of_type_JavaUtilList.get(i));
        i += 1;
      }
      a(localArrayList);
    }
    this.f = -1;
  }
  
  public void a(List<DoutuData> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void a(List<DoutuData> paramList, boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuEmotionAdapter", 2, "addSmartPicList removeEmptyData:" + paramBoolean);
    }
    if (paramLong != this.jdField_a_of_type_Long) {
      if (QLog.isColorLevel()) {
        QLog.e("DoutuEmotionAdapter", 2, "addSmartPicList key:" + paramLong + ", timeKey:" + this.jdField_a_of_type_Long);
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList != null) && (paramList != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("DoutuEmotionAdapter", 2, "addSmartPicList list:" + this.jdField_a_of_type_JavaUtilList + ", listAll:" + this.jdField_b_of_type_JavaUtilList);
    return;
    int j = paramList.size();
    if (this.f > 0)
    {
      this.jdField_b_of_type_JavaUtilList.addAll(this.f, paramList);
      this.f += paramList.size();
    }
    int k = this.jdField_a_of_type_JavaUtilList.size();
    paramList = new ArrayList();
    int i = 0;
    while ((i < k + j) && (i < this.jdField_b_of_type_JavaUtilList.size()))
    {
      if ((!paramBoolean) || (!((DoutuData)this.jdField_b_of_type_JavaUtilList.get(i)).pic_md5.equalsIgnoreCase("abababababababababababab"))) {
        paramList.add(this.jdField_b_of_type_JavaUtilList.get(i));
      }
      i += 1;
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_ComTencentMobileqqDoutuDoutuData);
      this.f = -1;
    }
    a(paramList);
  }
  
  public void b()
  {
    int j;
    int k;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList != null))
    {
      j = this.jdField_a_of_type_JavaUtilList.size();
      k = this.jdField_b_of_type_JavaUtilList.size();
      if (j < k) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while ((i < k) && (i < jdField_a_of_type_Int + j))
    {
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.get(i));
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.e("DoutuEmotionAdapter", 2, "get view position exception , position = " + paramInt + ",size = " + this.jdField_a_of_type_JavaUtilList.size());
      localObject1 = paramView;
      paramView = null;
    }
    DoutuData localDoutuData;
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localDoutuData = (DoutuData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      URL localURL;
      if (localDoutuData == null)
      {
        QLog.e("DoutuEmotionAdapter", 1, "getView emoticon empty position = " + paramInt);
        localURL = null;
        localObject1 = paramView;
        paramView = localURL;
      }
      else
      {
        if ((paramView == null) || (paramView.getTag() == null))
        {
          localObject1 = new armq(null);
          ((armq)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView = new ViewGroup.LayoutParams(this.jdField_b_of_type_Int, this.c);
          ((armq)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
          ((armq)localObject1).jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
          paramView = new RelativeLayout.LayoutParams(this.d, this.e);
          paramView.addRule(13, -1);
          ((armq)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((armq)localObject1).jdField_a_of_type_ComTencentImageURLImageView, paramView);
          ((armq)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
          ((armq)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839402));
          paramView = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 30.0F), (int)(this.jdField_a_of_type_Float * 30.0F));
          paramView.addRule(13, -1);
          ((armq)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((armq)localObject1).jdField_a_of_type_AndroidWidgetProgressBar, paramView);
          paramView = ((armq)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
          paramView.setTag(localObject1);
          ((armq)localObject1).jdField_a_of_type_ComTencentMobileqqDoutuDoutuData = localDoutuData;
          ((armq)localObject1).jdField_a_of_type_Int = paramInt;
          ((armq)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          if (localDoutuData.thumb_down_url == null) {
            break label675;
          }
        }
        try
        {
          localURL = new URL(localDoutuData.thumb_down_url);
          if (localURL == null)
          {
            QLog.e("DoutuEmotionAdapter", 1, "getView url = null");
            localURL = null;
            localObject1 = paramView;
            paramView = localURL;
            continue;
            localObject1 = (armq)paramView.getTag();
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            QLog.e("DoutuEmotionAdapter", 1, "getView url exception e = " + localMalformedURLException.getMessage());
            localObject2 = null;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mPlayGifImage = true;
          localURLDrawableOptions.mExtraInfo = localDoutuData;
          localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
          if (((URLDrawable)localObject2).getStatus() == 1) {
            break label627;
          }
        }
      }
    }
    ((URLDrawable)localObject2).setTag(localDoutuData);
    ((URLDrawable)localObject2).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
      ((URLDrawable)localObject2).restartDownload();
    }
    label566:
    ((armq)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
    ((armq)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
    ((armq)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setTag(localObject1);
    ((armq)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
    ((armq)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setFocusableInTouchMode(true);
    paramView.setOnClickListener(this);
    for (;;)
    {
      localObject1 = paramView;
      break;
      label627:
      ((armq)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localDoutuData.pic_md5, localDoutuData.pic_down_url);
      break label566;
      label675:
      ((armq)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof armq))) {}
    for (localObject1 = (armq)localObject1;; localObject1 = null)
    {
      if (localObject1 == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        DoutuData localDoutuData = ((armq)localObject1).jdField_a_of_type_ComTencentMobileqqDoutuDoutuData;
        if ((localDoutuData != null) && (localDoutuData.thumb_down_url != null))
        {
          Object localObject2 = (URLDrawable)((armq)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
          if (localObject2 != null)
          {
            localObject2 = ((URLDrawable)localObject2).getFileInLocal();
            if (localObject2 != null)
            {
              localObject2 = ((File)localObject2).getPath();
              Intent localIntent = new Intent();
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localObject2);
              localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
              localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1044);
              localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
              localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
              localIntent.putExtra("send_in_background", true);
              localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
              localIntent.putExtra("quick_send_original_size", localDoutuData.pic_size);
              localIntent.putExtra("quick_send_original_md5", localDoutuData.pic_md5);
              localIntent.putExtra("quick_send_thumb_md5", localDoutuData.thumb_md5);
              localIntent.putExtra("PicContants.NEED_COMPRESS", false);
              ThreadManager.post(new SendPhotoTask(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, null), 8, null, false);
              bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FAB", "0X8007FAB", 0, 0, "", String.valueOf(((armq)localObject1).jdField_a_of_type_Int + 1), localDoutuData.pic_md5, localDoutuData.pic_down_url);
              this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData = localDoutuData;
              if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
                this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(80).sendToTarget();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armo
 * JD-Core Version:    0.7.0.1
 */