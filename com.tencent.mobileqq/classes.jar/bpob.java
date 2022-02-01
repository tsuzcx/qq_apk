import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import java.util.List;

public class bpob
  extends bpnp<bpni>
  implements View.OnClickListener
{
  public bpob(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Bpnb == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {}
    for (Object localObject = new bpoc(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((bpni)this.jdField_a_of_type_Bpnb).a(), ((bpni)this.jdField_a_of_type_Bpnb).a(), this);; localObject = (bpoc)paramView)
    {
      ((bpoc)localObject).a((bpni)this.jdField_a_of_type_Bpnb, paramInt, getCount(), a());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (ImageView)paramView.findViewById(2131370257);
    int i = ((Integer)((ImageView)localObject1).getTag(2131378270)).intValue();
    bpnj localbpnj = (bpnj)((bpni)this.jdField_a_of_type_Bpnb).jdField_a_of_type_JavaUtilList.get(i);
    Object localObject2 = (Boolean)((ImageView)localObject1).getTag(2131378248);
    int j;
    int k;
    float f;
    if ((localObject2 != null) && (((Boolean)localObject2).booleanValue()))
    {
      localbpnj.a = ((ImageView)localObject1).getDrawable();
      localObject2 = localbpnj.a;
      if (localObject2 != null)
      {
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        i = ((Drawable)localObject2).getIntrinsicWidth();
        j = ((ImageView)localObject1).getWidth();
        k = ((ImageView)localObject1).getPaddingLeft();
        if (j <= i) {
          break label206;
        }
        f = (((j - i) / 2 - k) * 2 + i) / i;
        f = (float)(f * ((bpni)this.jdField_a_of_type_Bpnb).jdField_a_of_type_Double);
        localObject1 = boso.a();
        this.jdField_a_of_type_Bolv.a(localbpnj, ((bosp)localObject1).a, ((bosp)localObject1).b, f);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label206:
      f = (i - (k + (i - j) / 2) * 2) / i;
      break;
      yqp.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpob
 * JD-Core Version:    0.7.0.1
 */