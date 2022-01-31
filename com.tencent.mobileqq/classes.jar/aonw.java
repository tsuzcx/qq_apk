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
import java.util.List;

public class aonw
  extends aoni
{
  private final int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private LocalFileBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity;
  private List<FileInfo> jdField_a_of_type_JavaUtilList;
  private final int b = 1;
  
  public aonw(Context paramContext, List<FileInfo> paramList, LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    super(paramContext, paramLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity = paramLocalFileBrowserActivity;
  }
  
  private View a(FileInfo paramFileInfo, ViewGroup paramViewGroup)
  {
    aonx localaonx = new aonx(this);
    if (!paramFileInfo.c())
    {
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131494879, paramViewGroup, false);
      localaonx.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramFileInfo);
      localaonx.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localaonx.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localaonx.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localaonx);
      localaonx.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramFileInfo.findViewById(2131300623));
      localaonx.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131300609));
      localaonx.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localaonx.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localaonx);
      localaonx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131309500));
      localaonx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramFileInfo.findViewById(2131300621));
      localaonx.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      localaonx.b = ((TextView)paramFileInfo.findViewById(2131300624));
      localaonx.c = ((TextView)paramFileInfo.findViewById(2131300607));
      localaonx.d = ((TextView)paramFileInfo.findViewById(2131303219));
      localaonx.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramFileInfo.findViewById(2131296354));
      localaonx.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
    }
    for (;;)
    {
      paramFileInfo.setTag(localaonx);
      return paramFileInfo;
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131494886, paramViewGroup, false);
      paramFileInfo.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localaonx.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131300635));
      localaonx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131309510));
      localaonx.jdField_a_of_type_AndroidWidgetTextView = ((EllipsizingTextView)paramFileInfo.findViewById(2131300638));
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
    if (localFileInfo == null) {
      return null;
    }
    if (paramView == null) {}
    for (;;)
    {
      try
      {
        paramViewGroup = a(localFileInfo, paramViewGroup);
        paramView = paramViewGroup;
      }
      catch (Exception paramViewGroup)
      {
        continue;
      }
      try
      {
        paramViewGroup = (aonx)paramView.getTag();
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = localFileInfo;
        if (localFileInfo.c())
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843371);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
          paramViewGroup.jdField_a_of_type_Int = paramInt;
        }
        else
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          apck.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.c(), apck.a(localFileInfo.c()));
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.f())
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(aonm.a(localFileInfo));
            String str1 = apea.b(localFileInfo.b());
            String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.getString(2131626862);
            paramViewGroup.c.setText(str1 + str2 + apdh.a(localFileInfo.a()));
            paramViewGroup.jdField_a_of_type_Int = paramInt;
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        return paramView;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aonw
 * JD-Core Version:    0.7.0.1
 */