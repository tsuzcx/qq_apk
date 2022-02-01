import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.mobileqq.troop.homework.recite.ui.PinyinTextView;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteDisplayView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class beld
  extends BaseAdapter
{
  public static int c = 1;
  public static int d = 2;
  int jdField_a_of_type_Int = 1;
  Context jdField_a_of_type_AndroidContentContext;
  ReciteDisplayView jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView;
  List<ParagraphInfo> jdField_a_of_type_JavaUtilList;
  protected int b;
  int e = c;
  int f = -2;
  int g = -1;
  
  public beld(ReciteDisplayView paramReciteDisplayView, Context paramContext, List<ParagraphInfo> paramList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView = paramReciteDisplayView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = mum.b(paramContext);
    int i = paramList.size() - 1;
    while (i > 0)
    {
      paramReciteDisplayView = (ParagraphInfo)paramList.get(i);
      paramReciteDisplayView.paragraphPos = i;
      if ((TextUtils.isEmpty(paramReciteDisplayView.content_html)) && (TextUtils.isEmpty(paramReciteDisplayView.content_pinyin))) {
        paramList.remove(i);
      }
      i -= 1;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt1;
    this.e = paramInt2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((ParagraphInfo)this.jdField_a_of_type_JavaUtilList.get(i)).setWordColor(3);
      i += 1;
    }
    this.e = c;
    notifyDataSetChanged();
  }
  
  public void a(WordInfo paramWordInfo)
  {
    if ((paramWordInfo == null) || (paramWordInfo.paragraphPos < 0) || (paramWordInfo.wordPos < 0) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ReciteDetect.ReciteDisplayView", 1, "recite result = " + paramWordInfo.text);
    }
    if (paramWordInfo.paragraphPos > this.f) {
      this.f = paramWordInfo.paragraphPos;
    }
    for (this.g = paramWordInfo.wordPos;; this.g = paramWordInfo.wordPos) {
      do
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.a = paramWordInfo;
        notifyDataSetChanged();
        return;
      } while ((paramWordInfo.paragraphPos != this.f) || (paramWordInfo.wordPos <= this.g));
    }
  }
  
  public int getCount()
  {
    int j;
    if (this.e == c)
    {
      j = this.jdField_a_of_type_JavaUtilList.size();
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      j = i;
      if (((ParagraphInfo)localIterator.next()).paragraphPos > this.f) {
        break;
      }
      i += 1;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    belc localbelc;
    if (paramView == null)
    {
      localbelc = new belc();
      localbelc.a = new PinyinTextView(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
      paramView = localbelc.a;
      paramView.setTag(localbelc);
    }
    for (;;)
    {
      localbelc = (belc)paramView.getTag();
      ParagraphInfo localParagraphInfo = (ParagraphInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (this.e == d) {
        if (paramInt == getCount() - 1) {
          localbelc.a.setWordInfos(localParagraphInfo, this.g, true);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localbelc.a.setWordInfos(localParagraphInfo, this.g, false);
        continue;
        localbelc.a.setWordInfos(localParagraphInfo, this.g, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beld
 * JD-Core Version:    0.7.0.1
 */