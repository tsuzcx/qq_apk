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
    Object localObject1;
    if (paramInt < 0)
    {
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getMemberView invalide position ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("QuestionOptionsAdapter", 4, ((StringBuilder)localObject1).toString());
      }
      return paramView;
    }
    QuestionOptionInfo localQuestionOptionInfo = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource.a(paramInt);
    Object localObject2;
    if (!(paramView instanceof QuestionOptionItemView))
    {
      paramView = (QuestionOptionItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558658, null);
      paramView.a();
      localObject1 = paramView;
      localObject2 = paramView;
    }
    else
    {
      localObject2 = (QuestionOptionItemView)paramView;
      localObject1 = paramView;
    }
    ((QuestionOptionItemView)localObject2).a(localQuestionOptionInfo);
    return localObject1;
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource != null) && (paramInt >= 0))
    {
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject != null)
      {
        localObject = (QuestionOptionItemView)((ViewGroup)localObject).getChildAt(paramInt);
        QuestionOptionInfo localQuestionOptionInfo = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource.a(paramInt);
        if (localObject == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("QuestionOptionsAdapter", 4, "updateItemView itemView is null or member is null");
          }
          return;
        }
        ((QuestionOptionItemView)localObject).a(localQuestionOptionInfo);
        return;
      }
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid params updateItemView at ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QuestionOptionsAdapter", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public int getCount()
  {
    return 4;
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource;
    if (localObject == null) {
      return new QuestionOptionInfo();
    }
    QuestionOptionInfo localQuestionOptionInfo = ((QuestionOptionsDataSource)localObject).a(paramInt);
    localObject = localQuestionOptionInfo;
    if (localQuestionOptionInfo == null) {
      localObject = new Object();
    }
    return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsAdapter
 * JD-Core Version:    0.7.0.1
 */