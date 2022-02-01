import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class benb
{
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<bekd> b = new ArrayList(4);
  ArrayList<bend> c = new ArrayList();
  
  public benb(Context paramContext, View.OnClickListener paramOnClickListener, LinearLayout paramLinearLayout)
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
        bend localbend = (bend)localIterator.next();
        if (localbend != null) {
          localbend.c();
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
    bene localbene = new bene();
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561352, null);
    localbene.a(localView);
    localbene.b(localView);
    this.c.add(new benc(this, localbene));
    if (paramInt * 2 < this.b.size()) {
      ((bekd)this.b.get(paramInt * 2)).a(bejv.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((bekd)this.b.get(paramInt * 2)).b));
    }
    for (bekd localbekd1 = (bekd)this.b.get(paramInt * 2);; localbekd1 = null)
    {
      if (paramInt * 2 + 1 < this.b.size()) {
        ((bekd)this.b.get(paramInt * 2 + 1)).a(bejv.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((bekd)this.b.get(paramInt * 2 + 1)).b));
      }
      for (bekd localbekd2 = (bekd)this.b.get(paramInt * 2 + 1);; localbekd2 = null)
      {
        if (localbekd1 == null)
        {
          localbene.a.a.setVisibility(4);
          if (localbekd2 != null) {
            break label282;
          }
          localbene.b.a.setVisibility(4);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          return;
          localbene.a.a.setVisibility(0);
          localbene.a(localbekd1, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidContentContext);
          break;
          label282:
          localbene.b.a.setVisibility(0);
          localbene.b(localbekd2, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidContentContext);
        }
      }
    }
  }
  
  public void a(ArrayList<bekd> paramArrayList)
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
      bend localbend = (bend)localIterator.next();
      if (localbend != null) {
        localbend.b();
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      bend localbend = (bend)localIterator.next();
      if (localbend != null) {
        localbend.a();
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      bend localbend = (bend)localIterator.next();
      if (localbend != null) {
        localbend.c();
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
 * Qualified Name:     benb
 * JD-Core Version:    0.7.0.1
 */