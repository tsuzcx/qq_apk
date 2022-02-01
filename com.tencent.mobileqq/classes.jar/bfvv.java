import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.mobileqq.troop.widget.MediaPreviewAdapter.2;
import com.tencent.mobileqq.troop.widget.MediaPreviewAdapter.3;
import com.tencent.mobileqq.troop.widget.MediaPreviewAdapter.4;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class bfvv
  extends BaseAdapter
  implements apue, URLDrawableDownListener
{
  public static final int[] a;
  protected Context a;
  public Drawable a;
  protected SparseArray<WeakReference<URLDrawable>> a;
  protected LayoutInflater a;
  protected apuc a;
  public Gallery a;
  protected List<MediaPreviewInfo> a;
  protected boolean a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 480, 480 };
  }
  
  public bfvv(Context paramContext, Gallery paramGallery)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentWidgetGallery = paramGallery;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130838062);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    paramContext = (apul)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(180);
    if (paramContext == null) {}
    this.jdField_a_of_type_Apuc = paramContext.a();
    this.jdField_a_of_type_Apuc.a(this);
  }
  
  public Drawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = bdzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mLoadingDrawable = bdzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public MediaPreviewInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (MediaPreviewInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    a(true, -1);
    if (this.jdField_a_of_type_Apuc != null) {
      this.jdField_a_of_type_Apuc.b(this);
    }
  }
  
  public void a(int paramInt, ImageView paramImageView, File paramFile, String paramString)
  {
    String str = paramFile.getAbsolutePath();
    Object localObject = zmg.a(str);
    paramFile = (File)localObject;
    if (localObject == null) {
      paramFile = jdField_a_of_type_ArrayOfInt;
    }
    localObject = new QQLiveDrawable.QQLiveDrawableParams();
    int i = paramFile[1];
    int j = paramFile[2];
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPreviewWidth = i;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPreviewHeight = j;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPlayType = 2;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSourceType = 3;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSource = str;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mCoverUrl = paramString;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mMute = false;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mCoverLoadingDrawable = PAVideoView.a;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mLoopback = true;
    ((QQLiveDrawable.QQLiveDrawableParams)localObject).mLoopback = true;
    paramFile = URLDrawable.URLDrawableOptions.obtain();
    paramFile.mExtraInfo = localObject;
    paramFile.mLoadingDrawable = a(paramString);
    paramFile = URLDrawable.getDrawable("qqlive://msgId=" + str, paramFile);
    paramImageView.setImageDrawable(paramFile);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WeakReference(paramFile));
    paramImageView.postDelayed(new MediaPreviewAdapter.2(this), 100L);
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "doShowVideoFile() drawable = " + paramImageView.getDrawable());
    }
  }
  
  protected void a(int paramInt, MediaPreviewInfo paramMediaPreviewInfo, bfvx parambfvx)
  {
    long l = System.currentTimeMillis();
    if ((parambfvx == null) || (paramMediaPreviewInfo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "loadVideo() mediaInfo = " + paramMediaPreviewInfo);
    }
    parambfvx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    File localFile;
    boolean bool2;
    if (!TextUtils.isEmpty(paramMediaPreviewInfo.c))
    {
      localFile = new File(paramMediaPreviewInfo.c);
      bool2 = localFile.exists();
      if (bool2) {
        a(paramInt, parambfvx.jdField_a_of_type_ComTencentImageURLImageView, localFile, paramMediaPreviewInfo.jdField_a_of_type_JavaLangString);
      }
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.e("MediaPreviewAdapter", 2, "loadVideo() videoFileExsits = " + bool2 + ", videoLocalPath = " + paramMediaPreviewInfo.c);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(paramMediaPreviewInfo.b))
        {
          bool1 = apuc.b(paramMediaPreviewInfo.b);
          if (bool1)
          {
            localFile = apuc.a(paramMediaPreviewInfo.b);
            a(paramInt, parambfvx.jdField_a_of_type_ComTencentImageURLImageView, localFile, paramMediaPreviewInfo.jdField_a_of_type_JavaLangString);
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.e("MediaPreviewAdapter", 2, "loadVideo() videoFileExsits = " + bool1 + ", videoUrl = " + paramMediaPreviewInfo.b);
            bool2 = bool1;
          }
        }
      }
      if (!bool2)
      {
        if (TextUtils.isEmpty(paramMediaPreviewInfo.b)) {
          break label419;
        }
        parambfvx.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(a(paramMediaPreviewInfo.jdField_a_of_type_JavaLangString));
        if (bgnt.a(this.jdField_a_of_type_AndroidContentContext)) {
          break label401;
        }
        parambfvx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambfvx.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bfvw(this, parambfvx, paramMediaPreviewInfo));
      }
      while (QLog.isColorLevel())
      {
        QLog.e("MediaPreviewAdapter", 2, "loadVideo() videoFileExsits = " + bool2 + ", videoUrl = " + paramMediaPreviewInfo.b + ", costTime = " + (System.currentTimeMillis() - l));
        return;
        label401:
        parambfvx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        b(paramMediaPreviewInfo, parambfvx);
        continue;
        label419:
        parambfvx.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if (QLog.isColorLevel()) {
          QLog.e("MediaPreviewAdapter", 2, "loadVideo() error startDownloadDynamicAvatar: " + paramMediaPreviewInfo.b);
        }
      }
      break;
    }
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (((paramURLDrawable instanceof URLDrawable)) && (paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)paramURLDrawable.getCurrDrawable()).resume();
    }
  }
  
  protected void a(URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    if (((paramURLDrawable instanceof URLDrawable)) && (paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      paramURLDrawable = (QQLiveDrawable)paramURLDrawable.getCurrDrawable();
      paramURLDrawable.pause();
      if (paramBoolean)
      {
        paramURLDrawable.setOnStateListener(null);
        paramURLDrawable.setParams(null);
        paramURLDrawable.release();
      }
    }
  }
  
  public void a(MediaPreviewInfo paramMediaPreviewInfo, bfvx parambfvx)
  {
    if ((parambfvx == null) || (paramMediaPreviewInfo == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MediaPreviewAdapter", 2, "loadBigImage() mediaInfo = " + paramMediaPreviewInfo);
      }
      try
      {
        paramMediaPreviewInfo = paramMediaPreviewInfo.jdField_a_of_type_JavaLangString;
        Object localObject = Uri.parse(paramMediaPreviewInfo).getScheme();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || ((!((String)localObject).equals("http")) && (!((String)localObject).equals("https")))) {}
        for (paramMediaPreviewInfo = new File(paramMediaPreviewInfo).toURL();; paramMediaPreviewInfo = new URL(paramMediaPreviewInfo))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AppSetting.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AppSetting.b;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bdzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          if (this.jdField_a_of_type_Boolean) {
            ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          }
          a(parambfvx.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
          parambfvx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramMediaPreviewInfo = URLDrawable.getDrawable(paramMediaPreviewInfo, (URLDrawable.URLDrawableOptions)localObject);
          parambfvx.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMediaPreviewInfo);
          parambfvx.jdField_a_of_type_ComTencentImageURLImageView.setTag(parambfvx);
          parambfvx.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
          return;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (MalformedURLException paramMediaPreviewInfo) {}
    }
    QLog.i("MediaPreviewAdapter", 2, paramMediaPreviewInfo.toString());
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    if (paramImageProgressCircle == null) {
      return;
    }
    if (paramImageProgressCircle.getVisibility() != 0) {
      paramImageProgressCircle.setVisibility(0);
    }
    paramImageProgressCircle.setProgress(paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView().getTag();
    MediaPreviewInfo localMediaPreviewInfo = a(this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition());
    if ((localMediaPreviewInfo != null) && (paramString.equals(localMediaPreviewInfo.b)) && ((localObject instanceof bfvx)))
    {
      a(((bfvx)localObject).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("MediaPreviewAdapter", 2, "onDownloadUpdate progress: " + paramInt);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "onDownloadFinish() isSuccess = " + paramBoolean1 + ", url = " + paramString);
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView().getTag();
    int i = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition();
    MediaPreviewInfo localMediaPreviewInfo = a(i);
    if ((localMediaPreviewInfo != null) && (paramString.equals(localMediaPreviewInfo.b)) && ((localObject instanceof bfvx)))
    {
      localObject = (bfvx)localObject;
      boolean bool = false;
      paramBoolean2 = bool;
      if (paramBoolean1)
      {
        paramBoolean2 = bool;
        if (apuc.b(localMediaPreviewInfo.b))
        {
          File localFile = apuc.a(localMediaPreviewInfo.b);
          ((bfvx)localObject).jdField_a_of_type_ComTencentImageURLImageView.post(new MediaPreviewAdapter.3(this, (bfvx)localObject, i, localFile, localMediaPreviewInfo));
          paramBoolean2 = true;
        }
      }
      if (!paramBoolean2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MediaPreviewAdapter", 2, "onDownloadFinish() finalSuc = " + paramBoolean2 + ", url = " + paramString);
        }
        ((bfvx)localObject).jdField_a_of_type_ComTencentImageURLImageView.post(new MediaPreviewAdapter.4(this, (bfvx)localObject));
      }
    }
  }
  
  public void a(List<MediaPreviewInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MediaPreviewAdapter", 2, "pauseOtherVideos() release = " + paramBoolean + ", specialPosition = " + paramInt);
      }
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
      int i = 0;
      if (i < j)
      {
        int k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        URLDrawable localURLDrawable = (URLDrawable)((WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).get();
        if (paramInt == k) {
          a(localURLDrawable);
        }
        for (;;)
        {
          i += 1;
          break;
          a(localURLDrawable, paramBoolean);
        }
      }
    } while (!paramBoolean);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  protected void b(MediaPreviewInfo paramMediaPreviewInfo, bfvx parambfvx)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Apuc != null) {
      this.jdField_a_of_type_Apuc.a(paramMediaPreviewInfo.b);
    }
    a(parambfvx.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, 0);
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "startDownloadVideo: " + paramMediaPreviewInfo.b + ", costTime = " + (System.currentTimeMillis() - l));
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559334, null);
      paramView = new bfvx(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368246));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131368346));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377795));
      localView.setTag(paramView);
      a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
      localObject = (MediaPreviewInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (((MediaPreviewInfo)localObject).jdField_a_of_type_Int != 1) {
        break label152;
      }
      a((MediaPreviewInfo)localObject, paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (bfvx)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label152:
      if (((MediaPreviewInfo)localObject).jdField_a_of_type_Int == 2) {
        a(paramInt, (MediaPreviewInfo)localObject, paramView);
      }
    }
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (paramView = paramURLDrawable.getURL().toString();; paramView = "")
    {
      if (paramThrowable == null) {}
      for (paramURLDrawable = "";; paramURLDrawable = paramThrowable.getMessage())
      {
        if (QLog.isColorLevel()) {
          QLog.i("MediaPreviewAdapter", 2, "onLoadFailed() urlStr = " + paramView + ", errorMsg = " + paramURLDrawable);
        }
        return;
      }
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    a(((bfvx)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramInt);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (bfvx)paramView.getTag();
    a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
    paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramURLDrawable);
    String str = "";
    paramView = str;
    if (paramURLDrawable != null)
    {
      paramView = str;
      if (paramURLDrawable.getURL() != null) {
        paramView = paramURLDrawable.getURL().toString();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MediaPreviewAdapter", 2, "onLoadSuccessed() urlStr = " + paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvv
 * JD-Core Version:    0.7.0.1
 */