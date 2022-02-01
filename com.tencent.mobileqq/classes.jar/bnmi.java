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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.List;

public class bnmi
  extends RecyclerView.Adapter<bnml>
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bnmk jdField_a_of_type_Bnmk;
  List<QIMFilterCategoryItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bnmi(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private boolean a()
  {
    bnid localbnid = bnic.a();
    if (localbnid == null) {
      return true;
    }
    return localbnid.a;
  }
  
  public bnml a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bnml(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558482, paramViewGroup, false));
  }
  
  public void a(bnmk parambnmk)
  {
    this.jdField_a_of_type_Bnmk = parambnmk;
  }
  
  public void a(bnml parambnml, int paramInt)
  {
    Object localObject1 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    QIMFilterCategoryItem localQIMFilterCategoryItem;
    Object localObject2;
    if (localObject1 != null)
    {
      localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject2 = bpye.a().c(this.jdField_a_of_type_Int);
      if (localObject2 == null) {
        break label282;
      }
    }
    label260:
    label272:
    label282:
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
        if ((!bool2) || (!a())) {
          break label260;
        }
        bnml.a(parambnml).setVisibility(0);
        label117:
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844546);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844546);
        if (paramInt != 0) {
          break label272;
        }
      }
      for (localObject1 = "https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none2.png";; localObject1 = ((QIMFilterCategoryItem)localObject1).d)
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        if (((URLDrawable)localObject1).getStatus() == 2) {
          ((URLDrawable)localObject1).restartDownload();
        }
        bnml.b(parambnml).setImageDrawable((Drawable)localObject1);
        bnml.a(parambnml).setText(localQIMFilterCategoryItem.b);
        if (this.jdField_a_of_type_Bnmk != null) {
          parambnml.itemView.setOnClickListener(new bnmj(this, parambnml));
        }
        parambnml.itemView.setTag(localQIMFilterCategoryItem);
        EventCollector.getInstance().onRecyclerBindViewHolder(parambnml, paramInt, getItemId(paramInt));
        return;
        bool2 = false;
        break;
        bnml.a(parambnml).setVisibility(8);
        break label117;
      }
    }
  }
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
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
 * Qualified Name:     bnmi
 * JD-Core Version:    0.7.0.1
 */