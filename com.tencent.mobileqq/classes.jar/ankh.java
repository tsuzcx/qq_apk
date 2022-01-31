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
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class ankh
  extends BaseAdapter
  implements agdg
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private List<EmotionPreviewInfo> jdField_a_of_type_JavaUtilList;
  
  public ankh(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846730);
    this.jdField_a_of_type_Int = aciy.a(207.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
    if (paramView != null) {
      return paramView;
    }
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    paramView = a(paramInt);
    if ((paramView == null) || (TextUtils.isEmpty(paramView.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmotionPreviewAdapter", 2, "getView Path is empty. position " + paramInt + ", size " + getCount());
      }
      localURLImageView.setImageDrawable(axwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return localURLImageView;
    }
    paramViewGroup = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramViewGroup != null) {
      localURLImageView.setImageDrawable(paramViewGroup);
    }
    for (;;)
    {
      localURLImageView.setContentDescription("照片" + paramInt);
      return localURLImageView;
      Object localObject = new File(paramView.a);
      paramView = null;
      if (((File)localObject).exists())
      {
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mRequestWidth = this.jdField_a_of_type_Int;
        paramViewGroup.mRequestHeight = this.jdField_a_of_type_Int;
        paramViewGroup.mLoadingDrawable = axwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramViewGroup.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramViewGroup.mPlayGifImage = true;
        localObject = a((File)localObject);
        if (localObject != null)
        {
          paramViewGroup = URLDrawable.getDrawable((URL)localObject, paramViewGroup);
          paramView = paramViewGroup;
          if (paramViewGroup != null)
          {
            paramView = paramViewGroup;
            switch (paramViewGroup.getStatus())
            {
            default: 
              paramViewGroup.setTag(Integer.valueOf(1));
              paramViewGroup.startDownload();
              paramView = paramViewGroup;
            }
          }
        }
        if (paramView != null)
        {
          localURLImageView.setImageDrawable(paramView);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
        }
        else
        {
          localURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
      else
      {
        localURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
      paramView.mLoadingDrawable = axwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ankh
 * JD-Core Version:    0.7.0.1
 */