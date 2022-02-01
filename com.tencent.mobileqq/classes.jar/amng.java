import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;

public abstract class amng
  extends bloj
  implements aoog, blih
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private aoof jdField_a_of_type_Aoof;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ExpandableListView a;
  
  public amng(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
    bhmq.a();
  }
  
  protected void a(amof paramamof, Bitmap paramBitmap)
  {
    a(paramamof, paramBitmap, true);
  }
  
  protected void a(amof paramamof, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramamof.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (antf.z.equals(paramamof.a))
    {
      paramamof.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844234);
      return;
    }
    if (antf.A.equals(paramamof.a))
    {
      paramamof.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844232);
      return;
    }
    if (antf.B.equals(paramamof.a))
    {
      paramamof.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844237);
      return;
    }
    if (antf.y.equals(paramamof.a))
    {
      paramamof.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130839573);
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_Aoof.a(paramamof.jdField_c_of_type_Int, paramamof.a);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bhmq.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Aoof.a())
        {
          this.jdField_a_of_type_Aoof.a(paramamof.a, paramamof.jdField_c_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramamof.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
      return;
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof amof)))
      {
        localObject = (amof)localObject;
        if (paramString != null) {
          break label69;
        }
        a((amof)localObject, null, false);
      }
      label69:
      while (!paramString.equals(((amof)localObject).a))
      {
        i += 1;
        break;
      }
      ((amof)localObject).jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
  }
  
  public int c_()
  {
    return 0;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return null;
  }
  
  public int getGroupCount()
  {
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Aoof.a()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Aoof.a();
      this.jdField_a_of_type_Aoof.c();
    }
    while (!this.jdField_a_of_type_Aoof.a()) {
      return;
    }
    this.jdField_a_of_type_Aoof.a();
    this.jdField_a_of_type_Aoof.b();
    a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amng
 * JD-Core Version:    0.7.0.1
 */