import android.content.Context;
import android.support.v4.view.ViewPager.LayoutParams;
import android.widget.AdapterView;
import android.widget.GridView;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterViewPagerAdapter.AdapterViewFactory;

public class ayqv
  implements AdapterViewPagerAdapter.AdapterViewFactory
{
  public ayqv(QzonePhotoView paramQzonePhotoView) {}
  
  public AdapterView create(Context paramContext, int paramInt)
  {
    do
    {
      try
      {
        paramContext = new GridView(paramContext);
        ViewPager.LayoutParams localLayoutParams;
        Context localContext = paramContext;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          paramContext.setNumColumns(4);
          paramContext.setFadingEdgeLength(0);
          paramContext.setHorizontalSpacing(QzonePhotoView.a(this.a));
          paramContext.setVerticalSpacing(QzonePhotoView.a(this.a));
          paramContext.setStretchMode(2);
          paramContext.setScrollingCacheEnabled(false);
          paramContext.setSelector(2131167276);
          localLayoutParams = new ViewPager.LayoutParams();
          localLayoutParams.gravity = 17;
          localLayoutParams.height = -2;
          localLayoutParams.width = -1;
          paramContext.setLayoutParams(localLayoutParams);
          localContext = paramContext;
          return localContext;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          continue;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        paramContext = null;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ProfileCard.QzonePhotoView", 2, "new gridview error", localOutOfMemoryError1);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqv
 * JD-Core Version:    0.7.0.1
 */