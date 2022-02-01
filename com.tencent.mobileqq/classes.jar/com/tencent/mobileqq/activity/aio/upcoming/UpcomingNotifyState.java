package com.tencent.mobileqq.activity.aio.upcoming;

public class UpcomingNotifyState
{
  private int jdField_a_of_type_Int = 1;
  private UpcomingNotifyState.OnStateChangeListener jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState$OnStateChangeListener;
  
  public UpcomingNotifyState() {}
  
  public UpcomingNotifyState(UpcomingNotifyState.OnStateChangeListener paramOnStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState$OnStateChangeListener = paramOnStateChangeListener;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState$OnStateChangeListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState$OnStateChangeListener.a(1);
        this.jdField_a_of_type_Int = 2;
      }
    }
    while ((this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState$OnStateChangeListener == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState$OnStateChangeListener.a(2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState$OnStateChangeListener != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState$OnStateChangeListener.a();
      this.jdField_a_of_type_Int = 3;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState$OnStateChangeListener != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState$OnStateChangeListener.b();
      this.jdField_a_of_type_Int = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.UpcomingNotifyState
 * JD-Core Version:    0.7.0.1
 */