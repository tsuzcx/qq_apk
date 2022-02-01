import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class asxz
  extends asti
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private HashMap<Integer, ArrayList<asya>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private View.OnClickListener b;
  private View.OnClickListener c;
  
  public asxz(Context paramContext, LinkedHashMap<String, List<FileManagerEntity>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.c = paramOnClickListener3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, asyb paramasyb)
  {
    boolean bool;
    switch (paramFileManagerEntity.status)
    {
    case 17: 
    default: 
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      return;
    case 2: 
    case 18: 
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
      paramasyb.jdField_a_of_type_Int = 2;
      return;
    case 3: 
      bool = atwl.a(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.bSend) && (bool)) {
        paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(3);
      }
      for (;;)
      {
        paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramasyb.jdField_a_of_type_Int = 3;
        return;
        paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      }
    case 1: 
      bool = atwl.a(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5) || (bool))
      {
        paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        return;
      }
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramasyb.jdField_a_of_type_Int = 1;
      return;
    case 0: 
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramasyb.jdField_a_of_type_Int = 3;
      bool = atwl.a(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.bSend) && (bool))
      {
        paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(3);
        return;
      }
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      return;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      return;
    case 4: 
      paramasyb.jdField_a_of_type_Int = 1;
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      return;
    case 9: 
    case 12: 
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      return;
    case 10: 
    case 11: 
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      return;
    case 13: 
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      paramasyb.jdField_a_of_type_Int = 1;
      return;
    case 14: 
    case 15: 
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      return;
    case -1: 
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
      paramasyb.jdField_a_of_type_Int = 1;
      paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      return;
    }
    paramasyb.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
    {
      localObject3 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (asya)((Iterator)localObject3).next();
          if (((asya)localObject2).jdField_a_of_type_Int != paramInt2) {
            break label950;
          }
          localObject1 = (FileManagerEntity)getChild(paramInt1, ((asya)localObject2).jdField_b_of_type_Int);
        }
      }
    }
    label950:
    for (;;)
    {
      break;
      for (localObject1 = localObject2; localObject1 == null; localObject1 = (FileManagerEntity)getChild(paramInt1, paramInt2)) {
        return paramView;
      }
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          localObject2 = new asyb(this);
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560842, paramViewGroup, false);
          paramView = paramViewGroup;
          paramViewGroup = paramView;
        }
        catch (Exception paramViewGroup)
        {
          continue;
        }
        try
        {
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376115));
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370531);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131361941));
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366568));
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366555));
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject2);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366566));
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366553));
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(afur.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramViewGroup = paramView;
          paramView.setTag(localObject2);
          paramViewGroup = paramView;
          atvo.a(((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject1);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_b_of_type_Int = paramInt1;
          paramViewGroup = paramView;
          ((asyb)localObject2).c = paramInt2;
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          paramViewGroup = paramView;
          if (!atvo.a(this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject1)) {
            continue;
          }
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_JavaLangObject = localObject1;
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.c);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(localObject2);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(((FileManagerEntity)localObject1).fileName);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(((FileManagerEntity)localObject1).fProgress * 100.0F));
          paramViewGroup = paramView;
          if (5 != ((FileManagerEntity)localObject1).cloudType)
          {
            paramViewGroup = paramView;
            atvo.b((FileManagerEntity)localObject1);
          }
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setEnabled(true);
          paramViewGroup = paramView;
          a((FileManagerEntity)localObject1, (asyb)localObject2);
          paramViewGroup = paramView;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f()) {
            continue;
          }
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(athc.a((FileManagerEntity)localObject1));
        }
        catch (Exception localException)
        {
          paramView = paramViewGroup;
          paramViewGroup = localException;
          paramViewGroup.printStackTrace();
          continue;
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          continue;
        }
        paramViewGroup = paramView;
        if (((FileManagerEntity)localObject1).nFileType == 13)
        {
          paramViewGroup = paramView;
          ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        }
        paramViewGroup = paramView;
        localObject3 = (LinearLayout.LayoutParams)((asyb)localObject2).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        paramViewGroup = paramView;
        ((LinearLayout.LayoutParams)localObject3).topMargin = afur.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup = paramView;
        ((asyb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
        paramViewGroup = paramView;
        ((asyb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        paramViewGroup = paramView;
        ((asyb)localObject2).jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
        paramViewGroup = paramView;
        atvo.a(((asyb)localObject2).jdField_b_of_type_AndroidWidgetTextView, (FileManagerEntity)localObject1);
        return paramView;
        localObject2 = (asyb)paramView.getTag();
        continue;
        paramViewGroup = paramView;
        ((asyb)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup = paramView;
        ((asyb)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        paramViewGroup = paramView;
        ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.b);
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i = 0;
    Object localObject1 = a(paramInt);
    if (localObject1 != null)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new ArrayList());
      }
      localObject1 = (ArrayList)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        int j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (FileManagerEntity)localIterator.next();
          int k;
          if ((((FileManagerEntity)localObject2).getCloudType() == 0) || ((((FileManagerEntity)localObject2).getCloudType() == 5) && (!((FileManagerEntity)localObject2).bSend) && (((FileManagerEntity)localObject2).status != 1)))
          {
            k = j + 1;
            j = i;
            i = k;
          }
          for (;;)
          {
            k = j;
            j = i;
            i = k;
            break;
            if (((FileManagerEntity)localObject2).sendCloudUnsuccessful())
            {
              k = j + 1;
              j = i;
              i = k;
            }
            else
            {
              localObject2 = new asya(this);
              ((asya)localObject2).jdField_a_of_type_Int = i;
              ((asya)localObject2).jdField_b_of_type_Int = (i + j);
              localArrayList.add(localObject2);
              k = i + 1;
              i = j;
              j = k;
            }
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
        i = ((ArrayList)localObject1).size() - j;
      }
    }
    else
    {
      return i;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    return ((ArrayList)localObject1).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxz
 * JD-Core Version:    0.7.0.1
 */