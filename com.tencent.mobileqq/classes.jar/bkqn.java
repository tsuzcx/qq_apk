import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCommonUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class bkqn
  extends RecyclerView.Adapter<bkqp>
  implements URLDrawableDownListener
{
  public ColorDrawable a;
  public Drawable a;
  public LayoutInflater a;
  public ArrayList<LocalMediaInfo> a;
  
  public bkqn(bkql parambkql)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidViewLayoutInflater = parambkql.getActivity().getLayoutInflater();
  }
  
  public TextView a()
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_Bkql.getActivity());
    localTextView.setGravity(17);
    localTextView.setTextSize(10.0F);
    localTextView.setTextColor(-1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setSize(QAlbumCommonUtil.dp2px(30.0F, this.jdField_a_of_type_Bkql.getResources()), QAlbumCommonUtil.dp2px(18.0F, this.jdField_a_of_type_Bkql.getResources()));
    localGradientDrawable.setCornerRadii(new float[] { QAlbumCommonUtil.dp2px(2.0F, this.jdField_a_of_type_Bkql.getResources()), QAlbumCommonUtil.dp2px(2.0F, this.jdField_a_of_type_Bkql.getResources()), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setColor(1291845632);
    localTextView.setBackgroundDrawable(localGradientDrawable);
    return localTextView;
  }
  
  public bkqp a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return null;
        } while (this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a == null);
        return new bkqp(this.jdField_a_of_type_Bkql, this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a.a());
      } while (this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a == null);
      return new bkqp(this.jdField_a_of_type_Bkql, this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a.b());
    } while (this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a == null);
    return new bkqp(this.jdField_a_of_type_Bkql, this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a.c());
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public List<LocalMediaInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(bkqp parambkqp, int paramInt)
  {
    bkqo localbkqo = new bkqo(this.jdField_a_of_type_Bkql);
    switch (getItemViewType(paramInt))
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a == null);
        this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a.a(paramInt, parambkqp, localbkqo);
        return;
      } while (this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a == null);
      this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a.b(paramInt, parambkqp, localbkqo);
      return;
    } while (this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a == null);
    this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a.c(paramInt, parambkqp, localbkqo);
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if ((!this.jdField_a_of_type_Bkql.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) && (QAlbumUtil.getMediaType((LocalMediaInfo)paramList.get(0)) == 2)) {
      paramList.remove(0);
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    this.jdField_a_of_type_Bkql.jdField_a_of_type_Bkrb.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    new Rect();
    paramView = (LocalMediaInfo)paramURLDrawable.getTag();
    int i = paramView.listViewPosition;
    if ((i == -1) || (paramView.visableTime == 0L)) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = SystemClock.uptimeMillis();
      l2 = paramView.visableTime;
    } while (!QLog.isColorLevel());
    QLog.d("PhotoListActivity", 2, "onLoadSuccessed,no next ,listViewPositon:" + i + " costTime:" + (l1 - l2) + " imageInfo;" + paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqn
 * JD-Core Version:    0.7.0.1
 */