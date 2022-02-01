import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class atzh
  extends atys
{
  private final int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private LocalFileBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity;
  private List<FileInfo> jdField_a_of_type_JavaUtilList;
  private final int b = 1;
  
  public atzh(Context paramContext, List<FileInfo> paramList, LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    super(paramContext, paramLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity = paramLocalFileBrowserActivity;
  }
  
  private View a(FileInfo paramFileInfo, ViewGroup paramViewGroup)
  {
    atzi localatzi = new atzi(this);
    if (!paramFileInfo.c())
    {
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560873, paramViewGroup, false);
      localatzi.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramFileInfo);
      localatzi.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localatzi.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localatzi.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localatzi);
      localatzi.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramFileInfo.findViewById(2131366617));
      localatzi.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131366604));
      localatzi.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localatzi.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localatzi);
      localatzi.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131376645));
      localatzi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramFileInfo.findViewById(2131366615));
      localatzi.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      localatzi.b = ((TextView)paramFileInfo.findViewById(2131366618));
      localatzi.c = ((TextView)paramFileInfo.findViewById(2131366602));
      localatzi.d = ((TextView)paramFileInfo.findViewById(2131369615));
      localatzi.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramFileInfo.findViewById(2131361941));
      localatzi.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
    }
    for (;;)
    {
      paramFileInfo.setTag(localatzi);
      return paramFileInfo;
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560881, paramViewGroup, false);
      paramFileInfo.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localatzi.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131366629));
      localatzi.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131376655));
      localatzi.jdField_a_of_type_AndroidWidgetTextView = ((EllipsizingTextView)paramFileInfo.findViewById(2131366632));
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((FileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).c()) {
      return -1;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localFileInfo == null) {}
    View localView;
    for (Object localObject = null;; localView = paramView)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          localObject = a(localFileInfo, paramViewGroup);
          paramView = (View)localObject;
        }
        catch (Exception localException2)
        {
          continue;
        }
        try
        {
          localObject = (atzi)paramView.getTag();
          ((atzi)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = localFileInfo;
          if (localFileInfo.c())
          {
            ((atzi)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844292);
            ((atzi)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            ((atzi)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
            ((atzi)localObject).jdField_a_of_type_Int = paramInt;
          }
          else
          {
            ((atzi)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            aunj.a(((atzi)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.c(), aunj.a(localFileInfo.c()));
            ((atzi)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.f())
            {
              ((atzi)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
              ((atzi)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(atyw.a(localFileInfo));
              String str1 = auoy.b(localFileInfo.b());
              String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.getString(2131692144);
              ((atzi)localObject).c.setText(str1 + str2 + auog.a(localFileInfo.a()));
              ((atzi)localObject).jdField_a_of_type_Int = paramInt;
            }
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        localException1.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzh
 * JD-Core Version:    0.7.0.1
 */