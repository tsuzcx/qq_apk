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

public class aqqx
  extends aqni
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private HashMap<Integer, ArrayList<aqqy>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Context jdField_b_of_type_AndroidContentContext;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener c;
  
  public aqqx(Context paramContext, LinkedHashMap<String, List<FileManagerEntity>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.c = paramOnClickListener3;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext);
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
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (aqqy)((Iterator)localObject3).next();
          if (((aqqy)localObject2).jdField_a_of_type_Int != paramInt2) {
            break label1556;
          }
          localObject1 = (FileManagerEntity)getChild(paramInt1, ((aqqy)localObject2).jdField_b_of_type_Int);
        }
      }
    }
    for (localObject1 = localObject2; localObject1 == null; localObject1 = (FileManagerEntity)getChild(paramInt1, paramInt2)) {
      return paramView;
    }
    if (paramView == null) {}
    for (;;)
    {
      try
      {
        localObject2 = new aqqz(this);
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560642, paramViewGroup, false);
        paramView = paramViewGroup;
        paramViewGroup = paramView;
      }
      catch (Exception paramViewGroup)
      {
        continue;
      }
      try
      {
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131375387));
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370088);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131361889));
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366315));
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366301));
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject2);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366313));
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366299));
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(aepi.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), aepi.a(70.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramViewGroup = paramView;
        paramView.setTag(localObject2);
        paramViewGroup = paramView;
        arrr.a(((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject1);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_b_of_type_Int = paramInt1;
        paramViewGroup = paramView;
        ((aqqz)localObject2).c = paramInt2;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup = paramView;
        if (!arrr.a(this.jdField_b_of_type_AndroidContentContext, (FileManagerEntity)localObject1)) {
          continue;
        }
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_JavaLangObject = localObject1;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.c);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(localObject2);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgressRingWidth(3.0F);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(((FileManagerEntity)localObject1).fileName);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(((FileManagerEntity)localObject1).fProgress * 100.0F));
        paramViewGroup = paramView;
        if (5 != ((FileManagerEntity)localObject1).cloudType)
        {
          paramViewGroup = paramView;
          arrr.c((FileManagerEntity)localObject1);
        }
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setEnabled(true);
        paramViewGroup = paramView;
        switch (((FileManagerEntity)localObject1).status)
        {
        case 17: 
          paramViewGroup = paramView;
          ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        }
      }
      catch (Exception localException)
      {
        paramView = paramViewGroup;
        paramViewGroup = localException;
        paramViewGroup.printStackTrace();
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_Int = 2;
        continue;
        paramViewGroup = paramView;
        paramBoolean = arso.a(localException.getFilePath());
        paramViewGroup = paramView;
        if ((!localException.bSend) || (!paramBoolean)) {
          continue;
        }
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(3);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_Int = 3;
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        continue;
        paramViewGroup = paramView;
        paramBoolean = arso.a(localException.getFilePath());
        paramViewGroup = paramView;
        if (localException.getCloudType() == 3) {
          continue;
        }
        paramViewGroup = paramView;
        if ((localException.getCloudType() != 5) && (!paramBoolean)) {
          continue;
        }
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_Int = 1;
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_Int = 3;
        paramViewGroup = paramView;
        paramBoolean = arso.a(localException.getFilePath());
        paramViewGroup = paramView;
        if ((!localException.bSend) || (!paramBoolean)) {
          continue;
        }
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(3);
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_Int = 1;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_Int = 1;
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_Int = 1;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        continue;
      }
      paramViewGroup = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
      {
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(arbs.a((FileManagerEntity)localObject1));
        paramViewGroup = paramView;
        if (((FileManagerEntity)localObject1).nFileType == 13)
        {
          paramViewGroup = paramView;
          ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        }
        paramViewGroup = paramView;
        localObject3 = (LinearLayout.LayoutParams)((aqqz)localObject2).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        paramViewGroup = paramView;
        ((LinearLayout.LayoutParams)localObject3).topMargin = aepi.a(3.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
        paramViewGroup = paramView;
        arrr.a(((aqqz)localObject2).jdField_b_of_type_AndroidWidgetTextView, (FileManagerEntity)localObject1);
        return paramView;
        localObject2 = (aqqz)paramView.getTag();
        continue;
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        paramViewGroup = paramView;
        ((aqqz)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        label1556:
        break;
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
              localObject2 = new aqqy(this);
              ((aqqy)localObject2).jdField_a_of_type_Int = i;
              ((aqqy)localObject2).jdField_b_of_type_Int = (i + j);
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
 * Qualified Name:     aqqx
 * JD-Core Version:    0.7.0.1
 */