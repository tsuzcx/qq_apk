import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.artfilter.FilterTemplate;
import com.tencent.mobileqq.util.BitmapManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import java.util.ArrayList;
import java.util.List;

public class ansj
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache;
  List jdField_a_of_type_JavaUtilList;
  int b;
  public int c = -1;
  
  public ansj(EditVideoArtFilter paramEditVideoArtFilter, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 120.0F);
    this.b = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 90.0F);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
  }
  
  public FilterTemplate a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (FilterTemplate)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    FilterTemplate localFilterTemplate = new FilterTemplate();
    this.jdField_a_of_type_JavaUtilList.add(localFilterTemplate);
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
    View localView1;
    if (paramView == null)
    {
      paramViewGroup = new ansk(this);
      localView1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969055, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131364878));
      paramViewGroup.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131364877);
      localView1.setTag(paramViewGroup);
    }
    FilterTemplate localFilterTemplate;
    for (;;)
    {
      localFilterTemplate = a(paramInt);
      if (localFilterTemplate != null) {
        break;
      }
      return localView1;
      paramViewGroup = (ansk)paramView.getTag();
      localView1 = paramView;
    }
    paramView = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localFilterTemplate.jdField_a_of_type_Int + localFilterTemplate.b);
    View localView2 = paramView;
    if (paramView == null)
    {
      if (paramInt != 0) {
        break label246;
      }
      paramView = BitmapManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_AndroidContentContext.getResources(), 2130839560, this.b, this.jdField_a_of_type_Int);
      localView2 = paramView;
      if (paramView != null)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localFilterTemplate.jdField_a_of_type_Int + localFilterTemplate.b, paramView);
        localView2 = paramView;
      }
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localView2);
    if (paramInt == 0) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("无滤镜");
    }
    for (;;)
    {
      if (paramInt != this.c) {
        break label299;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return localView1;
      label246:
      paramView = BitmapManager.a(localFilterTemplate.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("滤镜" + localFilterTemplate.c);
    }
    label299:
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansj
 * JD-Core Version:    0.7.0.1
 */