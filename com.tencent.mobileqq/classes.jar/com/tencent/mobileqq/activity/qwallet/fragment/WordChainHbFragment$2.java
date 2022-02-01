package com.tencent.mobileqq.activity.qwallet.fragment;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.widget.immersive.ImmersiveUtils;

class WordChainHbFragment$2
  implements View.OnFocusChangeListener
{
  WordChainHbFragment$2(WordChainHbFragment paramWordChainHbFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = new SoftKeyboardObserver(this.a.jdField_a_of_type_AndroidViewView, new WordChainHbFragment.2.1(this), ImmersiveUtils.getStatusBarHeight(this.a.getActivity()) + 160);
      WordChainHbFragment.a(this.a, 8);
    }
    do
    {
      return;
      WordChainHbFragment.a(this.a, 0);
    } while (this.a.jdField_a_of_type_ComTencentBizSoftKeyboardObserver == null);
    this.a.jdField_a_of_type_ComTencentBizSoftKeyboardObserver.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.2
 * JD-Core Version:    0.7.0.1
 */