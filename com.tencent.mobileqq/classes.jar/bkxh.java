import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.List;

public class bkxh
  extends RecyclerView.Adapter<bkxk>
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bkxj jdField_a_of_type_Bkxj;
  List<QIMFilterCategoryItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  
  public bkxh(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public bkxk a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bkxk(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558475, paramViewGroup, false));
  }
  
  public void a(bkxj parambkxj)
  {
    this.jdField_a_of_type_Bkxj = parambkxj;
  }
  
  public void a(bkxk parambkxk, int paramInt)
  {
    Object localObject1 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    QIMFilterCategoryItem localQIMFilterCategoryItem;
    Object localObject2;
    if (localObject1 != null)
    {
      localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject2 = bnhb.a().c(this.jdField_a_of_type_Int);
      if (localObject2 == null) {
        break label269;
      }
    }
    label259:
    label269:
    for (boolean bool1 = TextUtils.equals(((QIMFilterCategoryItem)localObject2).a, localQIMFilterCategoryItem.a);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        if (((localObject2 == null) || (((QIMFilterCategoryItem)localObject2).d())) && (localQIMFilterCategoryItem.d())) {
          bool2 = true;
        }
      }
      else
      {
        if ((!bool2) || (!this.jdField_a_of_type_Boolean)) {
          break label247;
        }
        bkxk.a(parambkxk).setVisibility(0);
        label117:
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844149);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844149);
        if (paramInt != 0) {
          break label259;
        }
      }
      for (localObject1 = "https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none2.png";; localObject1 = ((QIMFilterCategoryItem)localObject1).d)
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        if (((URLDrawable)localObject1).getStatus() == 2) {
          ((URLDrawable)localObject1).restartDownload();
        }
        bkxk.b(parambkxk).setImageDrawable((Drawable)localObject1);
        bkxk.a(parambkxk).setText(localQIMFilterCategoryItem.b);
        if (this.jdField_a_of_type_Bkxj != null) {
          parambkxk.itemView.setOnClickListener(new bkxi(this, parambkxk));
        }
        parambkxk.itemView.setTag(localQIMFilterCategoryItem);
        return;
        bool2 = false;
        break;
        label247:
        bkxk.a(parambkxk).setVisibility(8);
        break label117;
      }
    }
  }
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxh
 * JD-Core Version:    0.7.0.1
 */