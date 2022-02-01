import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class asrl
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private asrn jdField_a_of_type_Asrn;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public asrl(Context paramContext, asrn paramasrn)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Asrn = paramasrn;
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847845);
    this.jdField_a_of_type_Int = agej.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public static URL a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumbpreview");
    localStringBuilder.append("://");
    localStringBuilder.append(paramString1);
    if (paramString2 != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString2);
    }
    try
    {
      paramString1 = new URL(localStringBuilder.toString());
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreviewThumbAdapter", 2, paramString1.getMessage(), paramString1);
      }
    }
    return null;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.mMediaType = 0;
    localLocalMediaInfo.path = paramString;
    localLocalMediaInfo.thumbWidth = this.jdField_a_of_type_Int;
    localLocalMediaInfo.thumbHeight = this.jdField_a_of_type_Int;
    return localLocalMediaInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new asrm(this);
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559584, paramViewGroup, false);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131378825));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131378823));
      localView.setTag(paramView);
    }
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      localObject2 = a(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (asrm)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    if (((String)localObject2).equals(this.jdField_a_of_type_JavaLangString)) {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = a((String)localObject2);
      localObject2 = a((String)localObject2, "DEFAULT");
      URLDrawable localURLDrawable = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((localURLDrawable == null) || (!localURLDrawable.getURL().toString().equals(((URL)localObject2).toString())))
      {
        localObject2 = beyq.a((URL)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((URLDrawable)localObject2).setTag(localObject1);
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        paramView.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject2);
      }
      break;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Asrn != null) {
      this.jdField_a_of_type_Asrn.a(paramInt);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrl
 * JD-Core Version:    0.7.0.1
 */