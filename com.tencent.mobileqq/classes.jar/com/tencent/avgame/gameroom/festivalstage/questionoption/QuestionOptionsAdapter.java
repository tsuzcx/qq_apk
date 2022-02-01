package com.tencent.avgame.gameroom.festivalstage.questionoption;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QuestionOptionsAdapter
  extends BaseAdapter
{
  protected Context a;
  protected LayoutInflater a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected IQuestionOptionPresenter a;
  private QuestionOptionsDataSource jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource;
  
  public QuestionOptionsAdapter(Context paramContext, IQuestionOptionPresenter paramIQuestionOptionPresenter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter = paramIQuestionOptionPresenter;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource = new QuestionOptionsDataSource();
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource);
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter.a(this);
  }
  
  private View a(int paramInt, View paramView)
  {
    if (paramInt < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QuestionOptionsAdapter", 4, "getMemberView invalide position " + paramInt);
      }
      return paramView;
    }
    QuestionOptionInfo localQuestionOptionInfo = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource.a(paramInt);
    View localView;
    Object localObject;
    if (!(paramView instanceof QuestionOptionItemView))
    {
      paramView = (QuestionOptionItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558759, null);
      paramView.a();
      localView = paramView;
      localObject = paramView;
    }
    for (;;)
    {
      ((QuestionOptionItemView)localObject).a(localQuestionOptionInfo);
      return localView;
      localObject = (QuestionOptionItemView)paramView;
      localView = paramView;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource == null) || (paramInt < 0) || (this.jdField_a_of_type_AndroidViewViewGroup == null)) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QuestionOptionsAdapter", 4, "invalid params updateItemView at " + paramInt);
      }
    }
    QuestionOptionItemView localQuestionOptionItemView;
    QuestionOptionInfo localQuestionOptionInfo;
    do
    {
      return;
      localQuestionOptionItemView = (QuestionOptionItemView)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(paramInt);
      localQuestionOptionInfo = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource.a(paramInt);
      if (localQuestionOptionItemView != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QuestionOptionsAdapter", 4, "updateItemView itemView is null or member is null");
    return;
    localQuestionOptionItemView.a(localQuestionOptionInfo);
  }
  
  public int getCount()
  {
    return 4;
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource == null) {
      localObject = new QuestionOptionInfo();
    }
    QuestionOptionInfo localQuestionOptionInfo;
    do
    {
      return localObject;
      localQuestionOptionInfo = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource.a(paramInt);
      localObject = localQuestionOptionInfo;
    } while (localQuestionOptionInfo != null);
    return new Object();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    View localView = a(paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsAdapter
 * JD-Core Version:    0.7.0.1
 */