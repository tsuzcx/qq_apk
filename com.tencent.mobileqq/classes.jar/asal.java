import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticonview.EmotionPreviewInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class asal
  extends BaseAdapter
  implements akfl
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private List<EmotionPreviewInfo> jdField_a_of_type_JavaUtilList;
  
  public asal(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847826);
    this.jdField_a_of_type_Int = afur.a(207.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private URL a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = paramFile.toURI().toURL();
      return paramFile;
    }
    catch (MalformedURLException paramFile) {}
    return null;
  }
  
  public EmotionPreviewInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (EmotionPreviewInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<EmotionPreviewInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
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
    Object localObject1;
    if (paramView != null) {
      localObject1 = paramView;
    }
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = a(paramInt);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((EmotionPreviewInfo)localObject2).a))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmotionPreviewAdapter", 2, "getView Path is empty. position " + paramInt + ", size " + getCount());
      }
      ((URLImageView)localObject1).setImageDrawable(bdzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    Object localObject3 = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject3 != null) {
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
    }
    for (;;)
    {
      ((URLImageView)localObject1).setContentDescription("照片" + paramInt);
      break;
      Object localObject4 = new File(((EmotionPreviewInfo)localObject2).a);
      localObject2 = null;
      if (((File)localObject4).exists())
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = bdzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        localObject4 = a((File)localObject4);
        if (localObject4 != null)
        {
          localObject3 = URLDrawable.getDrawable((URL)localObject4, (URLDrawable.URLDrawableOptions)localObject3);
          localObject2 = localObject3;
          if (localObject3 != null)
          {
            localObject2 = localObject3;
            switch (((URLDrawable)localObject3).getStatus())
            {
            default: 
              ((URLDrawable)localObject3).setTag(Integer.valueOf(1));
              ((URLDrawable)localObject3).startDownload();
              localObject2 = localObject3;
            }
          }
        }
        if (localObject2 != null)
        {
          ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
        }
        else
        {
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
      else
      {
        ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          paramView = a(paramInt);
          if ((paramView != null) && (!TextUtils.isEmpty(paramView.a))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("EmotionPreviewAdapter", 2, "onCreateView Path is empty. position " + paramInt + ", size " + getCount());
        return null;
        paramViewGroup = new File(paramView.a);
      } while (!paramViewGroup.exists());
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = this.jdField_a_of_type_Int;
      paramView.mRequestHeight = this.jdField_a_of_type_Int;
      paramView.mLoadingDrawable = bdzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      paramView.mPlayGifImage = true;
      paramViewGroup = a(paramViewGroup);
    } while (paramViewGroup == null);
    paramView = URLDrawable.getDrawable(paramViewGroup, paramView);
    paramView.setTag(Integer.valueOf(1));
    paramView.startDownload();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
    return null;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData) {}
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asal
 * JD-Core Version:    0.7.0.1
 */