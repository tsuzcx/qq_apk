package com.tencent.mobileqq.app;

@Deprecated
public class BaseFragment
  extends QBaseFragment
{
  @Deprecated
  public static final String SHOULD_RESTORE_FROM_KILL = "should_restore_from_kill";
  
  public final BaseActivity getBaseActivity()
  {
    return (BaseActivity)getActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseFragment
 * JD-Core Version:    0.7.0.1
 */