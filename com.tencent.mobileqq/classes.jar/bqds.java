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

public class bqds
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  List<zaf> jdField_a_of_type_JavaUtilList;
  int b;
  public int c = -1;
  
  public bqds(EditVideoArtFilter paramEditVideoArtFilter, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = bqrh.b(this.jdField_a_of_type_AndroidContentContext, 120.0F);
    this.b = bqrh.b(this.jdField_a_of_type_AndroidContentContext, 90.0F);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
  }
  
  public zaf a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (zaf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<zaf> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    zaf localzaf = new zaf();
    this.jdField_a_of_type_JavaUtilList.add(localzaf);
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
    bqdt localbqdt;
    View localView1;
    if (paramView == null)
    {
      localbqdt = new bqdt(this);
      localView1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559316, null);
      localbqdt.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131378824));
      localbqdt.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131377300);
      localView1.setTag(localbqdt);
    }
    zaf localzaf;
    for (;;)
    {
      localzaf = a(paramInt);
      if (localzaf != null) {
        break;
      }
      EventCollector.getInstance().onListGetView(paramInt, localView1, paramViewGroup, getItemId(paramInt));
      return localView1;
      localbqdt = (bqdt)paramView.getTag();
      localView1 = paramView;
    }
    paramView = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localzaf.jdField_a_of_type_Int + localzaf.b);
    View localView2 = paramView;
    if (paramView == null)
    {
      if (paramInt != 0) {
        break label272;
      }
      paramView = bhgm.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_AndroidContentContext.getResources(), 2130841487, this.b, this.jdField_a_of_type_Int);
      label180:
      localView2 = paramView;
      if (paramView != null)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localzaf.jdField_a_of_type_Int + localzaf.b, paramView);
        localView2 = paramView;
      }
    }
    localbqdt.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localView2);
    if (paramInt == 0)
    {
      localbqdt.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131702715));
      label252:
      if (paramInt != this.c) {
        break label329;
      }
      localbqdt.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      break;
      label272:
      paramView = bhgm.a(localzaf.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      break label180;
      localbqdt.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131702818) + localzaf.c);
      break label252;
      label329:
      localbqdt.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqds
 * JD-Core Version:    0.7.0.1
 */