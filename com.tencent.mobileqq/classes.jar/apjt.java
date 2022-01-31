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
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class apjt
  extends BaseAdapter
  implements View.OnClickListener
{
  public static int a;
  private float jdField_a_of_type_Float;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  public apjx a;
  URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new apju(this);
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
  
  public apjt(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler, boolean paramBoolean, apjx paramapjx, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Apjx = paramapjx;
    if ((paramBoolean) && (this.jdField_a_of_type_Apjx != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Apjx.b))) {}
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
    this.jdField_b_of_type_Int = aepi.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.c = aepi.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.d = aepi.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.e = aepi.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.e("DoutuEmotionAdapter", 2, "get view position exception , position = " + paramInt + ",size = " + this.jdField_a_of_type_JavaUtilList.size());
      return null;
    }
    DoutuData localDoutuData = (DoutuData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localDoutuData == null)
    {
      QLog.e("DoutuEmotionAdapter", 1, "getView emoticon empty position = " + paramInt);
      return null;
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new apjv(null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ViewGroup.LayoutParams(this.jdField_b_of_type_Int, this.c);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.d, this.e);
      paramView.addRule(13, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView, paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839225));
      paramView = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 30.0F), (int)(this.jdField_a_of_type_Float * 30.0F));
      paramView.addRule(13, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar, paramView);
      paramView = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData = localDoutuData;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if (localDoutuData.thumb_down_url == null) {
        break label631;
      }
    }
    label644:
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = localDoutuData.thumb_down_url;
        if (!((String)localObject1).startsWith("https")) {
          break label644;
        }
        localObject1 = ((String)localObject1).replaceFirst("https", "http");
        localObject1 = new URL((String)localObject1);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject1;
        QLog.e("DoutuEmotionAdapter", 1, "getView url exception e = " + localMalformedURLException.getMessage());
        localObject2 = null;
        continue;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mExtraInfo = localDoutuData;
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        if (((URLDrawable)localObject2).getStatus() == 1) {
          break label584;
        }
      }
      if (localObject1 == null)
      {
        QLog.e("DoutuEmotionAdapter", 1, "getView url = null");
        return null;
        paramViewGroup = (apjv)paramView.getTag();
        break;
      }
      ((URLDrawable)localObject2).setTag(localDoutuData);
      ((URLDrawable)localObject2).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setTag(paramViewGroup);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setFocusableInTouchMode(true);
        paramView.setOnClickListener(this);
        return paramView;
        label584:
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(localDoutuData.pic_md5, localDoutuData.pic_down_url);
      }
      label631:
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof apjv))) {}
    for (paramView = (apjv)paramView;; paramView = null)
    {
      if (paramView == null) {}
      do
      {
        DoutuData localDoutuData;
        do
        {
          do
          {
            do
            {
              return;
              localDoutuData = paramView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData;
            } while ((localDoutuData == null) || (localDoutuData.thumb_down_url == null));
            paramView = (URLDrawable)paramView.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
          } while (paramView == null);
          paramView = paramView.getFileInLocal();
        } while (paramView == null);
        paramView = paramView.getPath();
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramView);
        localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1044);
        localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        localIntent.putExtra("send_in_background", true);
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
        localIntent.putExtra("doutuBigFileSize", localDoutuData.pic_size);
        localIntent.putExtra("doutuBigMd5", localDoutuData.pic_md5);
        localIntent.putExtra("doutuThumbMD5", localDoutuData.thumb_md5);
        localIntent.putExtra("doutuSupplierName", localDoutuData.suppliers_name);
        localIntent.putExtra("PicContants.NEED_COMPRESS", false);
        ThreadManager.post(new SendPhotoTask(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, null), 8, null, false);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FAB", "0X8007FAB", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData = localDoutuData;
      } while (this.jdField_a_of_type_MqqOsMqqHandler == null);
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(80).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjt
 * JD-Core Version:    0.7.0.1
 */