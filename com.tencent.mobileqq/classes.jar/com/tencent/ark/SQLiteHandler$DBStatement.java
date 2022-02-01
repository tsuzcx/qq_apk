package com.tencent.ark;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;

public class SQLiteHandler$DBStatement
{
  protected Cursor cursor;
  SQLiteDatabase db;
  protected int index = 1;
  protected boolean isQuery = false;
  protected boolean queryHasRow = false;
  protected ArrayList<String> queryParams;
  protected String querySql;
  protected SQLiteStatement stmt;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.SQLiteHandler.DBStatement
 * JD-Core Version:    0.7.0.1
 */