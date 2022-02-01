package com.tencent.avgame.gameroom.stage.guesssong;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.util.UiUtils;
import com.tencent.qphone.base.util.QLog;

class BaseGuessSongStageView$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BaseGuessSongStageView$5(BaseGuessSongStageView paramBaseGuessSongStageView, String paramString) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.b.getWidth() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.b.getPaddingLeft() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.b.getPaddingRight();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowGameTopicTips tip = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("BaseGuessSongStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowGameTopicTips tipWidth  = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.b.getWidth());
      QLog.d("BaseGuessSongStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowGameTopicTips caluWidth  = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("BaseGuessSongStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      StringBuilder localStringBuilder;
      if (UiUtils.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.b) > 1)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().b());
        localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.jdField_a_of_type_AndroidViewView.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 130 / 478);
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onShowMosaicImageGameTopicTips 130 w = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).width);
          localStringBuilder.append(", h = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
          QLog.d("BaseGuessSongStageView", 2, localStringBuilder.toString());
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a());
        localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.jdField_a_of_type_AndroidViewView.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 110 / 478);
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onShowMosaicImageGameTopicTips 110 w = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).width);
          localStringBuilder.append(", h = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
          QLog.d("BaseGuessSongStageView", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.BaseGuessSongStageView.5
 * JD-Core Version:    0.7.0.1
 */