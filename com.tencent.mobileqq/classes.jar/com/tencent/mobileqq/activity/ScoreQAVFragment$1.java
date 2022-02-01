package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.av.widget.RatingBar.OnRatingListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ScoreQAVFragment$1
  implements RatingBar.OnRatingListener
{
  ScoreQAVFragment$1(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void a(Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("ratingScore : ");
      paramObject.append(paramInt);
      QLog.d("ScoreActivity", 2, paramObject.toString());
    }
    paramObject = this.a;
    paramObject.e = paramInt;
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramInt <= 3)
    {
      try
      {
        if (ImageResUtil.a("qav_score_bad.jpg"))
        {
          paramObject = this.a.jdField_a_of_type_AndroidWidgetImageView;
          localObject = this.a.getResources();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(ImageResUtil.a());
          localStringBuilder.append("qav_score_bad.jpg");
          paramObject.setBackgroundDrawable(new BitmapDrawable((Resources)localObject, localStringBuilder.toString()));
        }
      }
      catch (OutOfMemoryError paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mIcon OOM: ");
          ((StringBuilder)localObject).append(paramObject);
          QLog.w("ScoreActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
      ScoreQAVFragment.a(this.a).setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.b.setText(2131695845);
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() > 0)) {
        ScoreQAVFragment.a(this.a).setAdapter(ScoreQAVFragment.a(this.a));
      } else if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "mDatas is invalid!");
      }
    }
    else if (paramInt > 3)
    {
      ScoreQAVFragment.a(paramObject).setVisibility(8);
      try
      {
        if (ImageResUtil.a("qav_score_good.jpg"))
        {
          paramObject = this.a.jdField_a_of_type_AndroidWidgetImageView;
          localObject = this.a.getResources();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(ImageResUtil.a());
          localStringBuilder.append("qav_score_good.jpg");
          paramObject.setBackgroundDrawable(new BitmapDrawable((Resources)localObject, localStringBuilder.toString()));
        }
      }
      catch (OutOfMemoryError paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mIcon OOM: ");
          ((StringBuilder)localObject).append(paramObject);
          QLog.w("ScoreActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.a.b.setText(2131695845);
    }
    if (paramInt > 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.a.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFF"));
    }
    else
    {
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.a.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
    }
    this.a.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment.1
 * JD-Core Version:    0.7.0.1
 */