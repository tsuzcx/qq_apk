import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class ayfp
  extends RecyclerView.Adapter<ayfq>
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<ayfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ayfp(QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  private BusinessInfoCheckUpdate.AppInfo a(ayfo paramayfo)
  {
    return ((azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(10, String.valueOf(paramayfo.c), paramayfo.f);
  }
  
  private void a(@NonNull ayfq paramayfq, ayfo paramayfo)
  {
    paramayfq.itemView.setContentDescription(paramayfo.jdField_a_of_type_JavaLangString + amtj.a(2131706978));
    paramayfq.itemView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramayfq.itemView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    paramayfq.itemView.setEnabled(true);
    paramayfq.itemView.setTag(paramayfo);
    bfpm.a(paramayfq.itemView, true);
  }
  
  private void b(@NonNull ayfq paramayfq, int paramInt)
  {
    int i = 3;
    int j = XPanelContainer.a;
    int k = XPanelContainer.b;
    if (paramInt <= 3) {}
    for (paramInt = i;; paramInt = 6)
    {
      paramInt = (j - k) / paramInt;
      paramayfq.itemView.setPadding(0, paramInt, 0, 0);
      return;
    }
  }
  
  private void b(@NonNull ayfq paramayfq, ayfo paramayfo)
  {
    ayfq.a(paramayfq).setVisibility(0);
    ayfq.a(paramayfq).setBackgroundDrawable(paramayfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    if ((paramayfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
    {
      paramayfq = (URLDrawable)paramayfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (paramayfq.getStatus() == 2) {
        paramayfq.restartDownload();
      }
    }
  }
  
  private void c(@NonNull ayfq paramayfq, ayfo paramayfo)
  {
    int i = 0;
    ayfq.a(paramayfq).setVisibility(0);
    ayfq.a(paramayfq).d();
    if (!TextUtils.isEmpty(paramayfo.c))
    {
      ayfq.b(paramayfq).setVisibility(8);
      paramayfo = a(paramayfo);
      if (paramayfo != null) {
        ayfq.a(paramayfq).a(paramayfo);
      }
      return;
    }
    paramayfq = ayfq.b(paramayfq);
    if (paramayfo.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      paramayfq.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  @NonNull
  public ayfq a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558876, null);
    paramInt = ViewUtils.dpToPx(15.0F);
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, (XPanelContainer.b - paramInt) / 2 + (XPanelContainer.a - XPanelContainer.b) / 2));
    return new ayfq(paramViewGroup);
  }
  
  public void a(@NonNull ayfq paramayfq, int paramInt)
  {
    ayfo localayfo = (ayfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    b(paramayfq, paramInt);
    b(paramayfq, localayfo);
    c(paramayfq, localayfo);
    ayfq.a(paramayfq).setText(localayfo.jdField_a_of_type_JavaLangString);
    bfpm.a(ayfq.a(paramayfq), false);
    a(paramayfq, localayfo);
  }
  
  public void a(List<ayfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfp
 * JD-Core Version:    0.7.0.1
 */