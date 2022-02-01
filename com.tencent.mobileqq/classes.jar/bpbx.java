import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.util.ArrayList;
import java.util.List;

public class bpbx
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  List<ywk> jdField_a_of_type_JavaUtilList;
  int b;
  public int c = -1;
  
  public bpbx(EditVideoArtFilter paramEditVideoArtFilter, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = bppm.b(this.jdField_a_of_type_AndroidContentContext, 120.0F);
    this.b = bppm.b(this.jdField_a_of_type_AndroidContentContext, 90.0F);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
  }
  
  public ywk a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (ywk)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<ywk> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    ywk localywk = new ywk();
    this.jdField_a_of_type_JavaUtilList.add(localywk);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.c = 0;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bpby localbpby;
    View localView1;
    if (paramView == null)
    {
      localbpby = new bpby(this);
      localView1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559316, null);
      localbpby.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131378663));
      localbpby.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131377160);
      localView1.setTag(localbpby);
    }
    ywk localywk;
    for (;;)
    {
      localywk = a(paramInt);
      if (localywk != null) {
        break;
      }
      EventCollector.getInstance().onListGetView(paramInt, localView1, paramViewGroup, getItemId(paramInt));
      return localView1;
      localbpby = (bpby)paramView.getTag();
      localView1 = paramView;
    }
    paramView = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localywk.jdField_a_of_type_Int + localywk.b);
    View localView2 = paramView;
    if (paramView == null)
    {
      if (paramInt != 0) {
        break label272;
      }
      paramView = bggl.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_AndroidContentContext.getResources(), 2130841477, this.b, this.jdField_a_of_type_Int);
      label180:
      localView2 = paramView;
      if (paramView != null)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localywk.jdField_a_of_type_Int + localywk.b, paramView);
        localView2 = paramView;
      }
    }
    localbpby.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localView2);
    if (paramInt == 0)
    {
      localbpby.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131702608));
      label252:
      if (paramInt != this.c) {
        break label329;
      }
      localbpby.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      break;
      label272:
      paramView = bggl.a(localywk.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      break label180;
      localbpby.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131702711) + localywk.c);
      break label252;
      label329:
      localbpby.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpbx
 * JD-Core Version:    0.7.0.1
 */