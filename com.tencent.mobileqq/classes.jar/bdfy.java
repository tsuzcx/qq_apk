import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class bdfy
{
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<bddb> b = new ArrayList(4);
  ArrayList<bdga> c = new ArrayList();
  
  public bdfy(Context paramContext, View.OnClickListener paramOnClickListener, LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
  }
  
  public int a()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.c == null)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        bdga localbdga = (bdga)localIterator.next();
        if (localbdga != null) {
          localbdga.c();
        }
      }
      this.c.clear();
      int j = this.b.size();
      int k = this.b.size() / 2;
      int i = 0;
      while (i < k + j % 2)
      {
        a(i);
        i += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    bdgb localbdgb = new bdgb();
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561291, null);
    localbdgb.a(localView);
    localbdgb.b(localView);
    this.c.add(new bdfz(this, localbdgb));
    if (paramInt * 2 < this.b.size()) {
      ((bddb)this.b.get(paramInt * 2)).a(bdct.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((bddb)this.b.get(paramInt * 2)).b));
    }
    for (bddb localbddb1 = (bddb)this.b.get(paramInt * 2);; localbddb1 = null)
    {
      if (paramInt * 2 + 1 < this.b.size()) {
        ((bddb)this.b.get(paramInt * 2 + 1)).a(bdct.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((bddb)this.b.get(paramInt * 2 + 1)).b));
      }
      for (bddb localbddb2 = (bddb)this.b.get(paramInt * 2 + 1);; localbddb2 = null)
      {
        if (localbddb1 == null)
        {
          localbdgb.a.a.setVisibility(4);
          if (localbddb2 != null) {
            break label282;
          }
          localbdgb.b.a.setVisibility(4);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          return;
          localbdgb.a.a.setVisibility(0);
          localbdgb.a(localbddb1, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidContentContext);
          break;
          label282:
          localbdgb.b.a.setVisibility(0);
          localbdgb.b(localbddb2, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidContentContext);
        }
      }
    }
  }
  
  public void a(ArrayList<bddb> paramArrayList)
  {
    this.b.clear();
    this.b.addAll(paramArrayList);
    a();
  }
  
  public void b()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      bdga localbdga = (bdga)localIterator.next();
      if (localbdga != null) {
        localbdga.b();
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      bdga localbdga = (bdga)localIterator.next();
      if (localbdga != null) {
        localbdga.a();
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      bdga localbdga = (bdga)localIterator.next();
      if (localbdga != null) {
        localbdga.c();
      }
    }
    this.c.clear();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfy
 * JD-Core Version:    0.7.0.1
 */